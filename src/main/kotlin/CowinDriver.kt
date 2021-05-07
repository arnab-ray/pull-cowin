import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

object CowinDriver {

    @JvmStatic
    fun main(args: Array<String>) {
        runBlocking {
            while (true) {
                try {
                    val inputData = DataInitializerForYoung.initializeData()
                    inputData.forEach {
                        DataPollingManager.pollCowin(
                            stateName = it.state,
                            districtName = it.district,
                            ageLimit = it.age,
                            shouldPostToSlack = true
                        )
                    }
                } catch (e: Exception) {
                    println(e.message)
                }
                println("------------------------------------------------------------------")
                println("------------------------------------------------------------------")
                println("------------------------------------------------------------------")
                delay(10_000)
            }
        }
    }
}
