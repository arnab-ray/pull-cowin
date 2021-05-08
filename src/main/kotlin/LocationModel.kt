data class LocationModel(
    val state: String,
    val district: String,
    val districtCode: String
)

data class LocationInfo(
    val locations: List<LocationModel>
)
