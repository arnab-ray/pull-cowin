import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Center(
    @JsonProperty("center_id")
    val centerId: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("state_name")
    val stateName: String,
    @JsonProperty("district_name")
    val districtName: String,
    @JsonProperty("block_name")
    val blockName: String,
    @JsonProperty("pincode")
    val pincode: String,
    @JsonProperty("lat")
    val lat: String,
    @JsonProperty("long")
    val long: String,
    @JsonProperty("from")
    val from: String,
    @JsonProperty("to")
    val to: String,
    @JsonProperty("fee_type")
    val feeType: String,
    @JsonProperty("sessions")
    val sessions: List<Session>
)
