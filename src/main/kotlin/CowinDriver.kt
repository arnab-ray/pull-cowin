import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

object CowinDriver {

    @JvmStatic
    fun main(args: Array<String>) {
        runBlocking {
            while (true) {
                try {
                    DataPollingManager.pollCowin("Karnataka", "BBMP")
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
