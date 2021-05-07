object DataInitializer {
    fun initializeData(): List<InputModel> {
        return listOf(
            InputModel(state = "Karnataka", district = "BBMP", age = 45),
            InputModel(state = "West Bengal", district = "Kolkata", age = 45),
            InputModel(state = "Maharashtra", district = "Pune", age = 45)
        )
    }
}

object DataInitializerForYoung {
    fun initializeData(): List<InputModel> {
        return listOf(
                InputModel(state = "Karnataka", district = "BBMP", age = 18),
                InputModel(state = "West Bengal", district = "Kolkata", age = 18),
                InputModel(state = "Maharashtra", district = "Pune", age = 18)
        )
    }
}
