import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class District(
    @JsonProperty("district_id")
    val districtId: String,
    @JsonProperty("district_name")
    val districtName: String
)
