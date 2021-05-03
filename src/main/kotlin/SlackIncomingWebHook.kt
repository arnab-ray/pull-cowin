import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.asynchttpclient.DefaultAsyncHttpClient
import org.asynchttpclient.RequestBuilder
import org.asynchttpclient.Response
import java.util.concurrent.CompletableFuture

data class SlackMessage(val text: String)

class SlackIncomingWebHook(private val slackUrl: String) {
    companion object {
        private val objectMapper = ObjectMapper().registerKotlinModule()
        private val httpClient = DefaultAsyncHttpClient()
    }

    fun sendMessage(message: SlackMessage) : CompletableFuture<Response> {
        val request = RequestBuilder()
            .setMethod("POST")
            .setUrl(slackUrl)
            .setBody(objectMapper.writeValueAsString(message))
            .build()

        return httpClient.executeRequest(request).toCompletableFuture()
    }
}
