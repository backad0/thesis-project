package client

import org.springframework.stereotype.Component
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

@Component
class BciClient(
    private val restTemplate: RestOperations
) {
    fun getCreditHistory(clientData: ClientData): CreditHistory {
        return CreditHistory()
    }
}
