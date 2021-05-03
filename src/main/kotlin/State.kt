import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class State(
    @JsonProperty("state_id")
    val stateId: String,
    @JsonProperty("state_name")
    val stateName: String
)
