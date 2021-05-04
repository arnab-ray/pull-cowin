import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.asynchttpclient.AsyncHttpClient
import org.asynchttpclient.DefaultAsyncHttpClient
import org.asynchttpclient.RequestBuilder
import org.asynchttpclient.util.HttpConstants
import java.text.SimpleDateFormat
import java.util.*

object DataPollingManager {
    private const val getStatesUrl = "https://cdn-api.co-vin.in/api/v2/admin/location/states"
    private const val getDistricts = "https://cdn-api.co-vin.in/api/v2/admin/location/districts/"
    private const val getSlotsAvailableTodayPrefix = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict"

    private val asyncHttpClient: AsyncHttpClient by lazy {
        DefaultAsyncHttpClient()
    }

    private val objectMapper: ObjectMapper by lazy {
        ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
    }

    suspend fun pollCowin(stateName: String, districtName: String, ageLimit: Int, shouldPostToSlack: Boolean) {
        val stateId = getStateId(stateName)
        val districtId = getDistrictId(districtName, stateId)
        val slots = getSlots(districtId, ageLimit).sortedBy { it.name }

        slots.forEach {
            val message = "${it.date} | ${it.pincode} | ${it.feeType} | ${it.name} = ${it.availableCapacity} (${it.vaccine})"
            println(message)
            if (shouldPostToSlack)
                sendSlackMessage(message, ageLimit)
        }
    }

    private suspend fun getStateId(stateName: String): String {
        val request = RequestBuilder(HttpConstants.Methods.GET)
            .setUrl(getStatesUrl)
            .setHeader("Content-Type", "application/json")
            .build()

        val response = withContext(Dispatchers.IO) {
            asyncHttpClient.executeRequest(request).get().responseBody
        }

        val states = withContext(Dispatchers.IO) {
            objectMapper.readValue(response, object: TypeReference<StateResponse>() {}).states
        }

        return states.first { it.stateName.equals(stateName, true) }.stateId
    }

    private suspend fun getDistrictId(districtName: String, stateId: String): String {
        val request = RequestBuilder(HttpConstants.Methods.GET)
            .setUrl(getDistricts + stateId)
            .setHeader("Content-Type", "application/json")
            .build()

        val response = withContext(Dispatchers.IO) {
            asyncHttpClient.executeRequest(request).get().responseBody
        }

        val districts = withContext(Dispatchers.IO) {
            objectMapper.readValue(response, object: TypeReference<DistrictResponse>() {}).districts
        }

        return districts.first { it.districtName.equals(districtName, true) }.districtId
    }

    private suspend fun getSlots(districtId: String, ageLimit: Int): List<MinInfo> {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy").format(Date(System.currentTimeMillis()))
        val getSlotsUrl = "$getSlotsAvailableTodayPrefix?district_id=$districtId&date=$dateFormat"
        println(getSlotsUrl)

        val request = RequestBuilder(HttpConstants.Methods.GET)
            .setUrl(getSlotsUrl)
            .setHeader("Content-Type", "application/json")
            .build()

        val response = withContext(Dispatchers.IO) {
            asyncHttpClient.executeRequest(request).get().responseBody
        }

        val centers = withContext(Dispatchers.IO) {
            objectMapper.readValue(response, object: TypeReference<CenterResponse>() {}).centers
        }

        val infos = mutableListOf<MinInfo>()

        centers.forEach { center ->
            val filteredSessions = center.sessions.filter { it.minAgeLimit == ageLimit && it.availableCapacity > 0}

            filteredSessions.forEach { session ->
                infos.add(MinInfo(date = session.date, pincode = center.pincode, name = center.name,
                    vaccine = session.vaccine, feeType = center.feeType, availableCapacity = session.availableCapacity))
            }
        }

        return infos
    }

    private fun sendSlackMessage(message: String, ageLimit: Int) {
        val slackIncomingWebHook = SlackIncomingWebhookConstructor.getIncomingWebHook(ageLimit)
        slackIncomingWebHook.sendMessage(SlackMessage(message))
    }
}
