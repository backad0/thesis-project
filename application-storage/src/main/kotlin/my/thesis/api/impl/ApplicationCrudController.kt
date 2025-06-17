package my.thesis.api.impl

import my.thesis.api.ApplicationCrudApi
import my.thesis.mapper.mapApplicationToResponse
import my.thesis.service.ApplicationCrudService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController


@RestController
class ApplicationCrudController(
    private val applicationCrudService: ApplicationCrudService
) : ApplicationCrudApi {

    override fun getApplication(id: String): ResponseEntity<ApplicationResponse> {
        return ResponseEntity.ok(
            mapApplicationToResponse(applicationCrudService.getApplication(id))
        )
    }
}