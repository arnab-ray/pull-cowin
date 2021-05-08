import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

object VacantSlotNotifier {

    @JvmStatic
    fun main(args: Array<String>) {
        runBlocking {
            while (true) {
                try {
                    val inputData = DataInitializer.initializeData()
                    inputData.forEach {
                        DataPollingManager.notifySlots(
                            districtId = it.districtCode,
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
