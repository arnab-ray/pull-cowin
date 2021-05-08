import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import java.io.File

object DataInitializer {
    private val objectMapper = ObjectMapper(YAMLFactory()).findAndRegisterModules()

    fun initializeData(): List<LocationModel> {
        val inputModels = objectMapper.readValue(File("src/main/resources/district_config.yaml"),
            object: TypeReference<LocationInfo>() {})
        println(inputModels)
        return inputModels.locations
    }
}

/*object DataInitializerForYoung {
    fun initializeData(): List<InputModel> {
        return listOf(
                InputModel(state = "Karnataka", district = "BBMP", districtCode = "294", age = 18),
                InputModel(state = "West Bengal", district = "Kolkata", districtCode = "725", age = 18),
                InputModel(state = "West Bengal", district = "North 24 Parganas", districtCode = "730", age = 18),
                InputModel(state = "Maharashtra", district = "Pune", districtCode = "363", age = 18)
        )
    }
}*/
