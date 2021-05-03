import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Session(
    @JsonProperty("session_id")
    val sessionId: String,
    @JsonProperty("date")
    val date: String,
    @JsonProperty("available_capacity")
    val availableCapacity: Int,
    @JsonProperty("min_age_limit")
    val minAgeLimit: Int,
    @JsonProperty("vaccine")
    val vaccine: String
)
