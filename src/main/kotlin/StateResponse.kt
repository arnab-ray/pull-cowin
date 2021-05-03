import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class StateResponse(
    @JsonProperty("states")
    val states: List<State>,
    @JsonProperty("ttl")
    val ttl: Long
)
