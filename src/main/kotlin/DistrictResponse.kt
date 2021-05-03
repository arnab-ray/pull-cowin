import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class DistrictResponse(
    @JsonProperty("districts")
    val districts: List<District>,
    @JsonProperty("ttl")
    val ttl: Long
)
