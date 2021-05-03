import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class MinInfo(
    val date: String,
    val pincode: String,
    val name: String,
    val feeType: String,
    val availableCapacity: Int
)
