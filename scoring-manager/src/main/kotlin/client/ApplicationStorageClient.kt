package client

import org.springframework.stereotype.Component
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

@Component
class ApplicationStorageClient(
    private val restTemplate: RestOperations
) {
    fun getApplication(applicationId: String): ApplicationResponse {
        return requireNotNull(restTemplate.getForObject(
            UriComponentsBuilder
                .fromUriString("localhost:8080/application-storage/application/{id}")
                .build()
                .toString(),
            ApplicationResponse::class.java,
            applicationId
        ))
    }
}