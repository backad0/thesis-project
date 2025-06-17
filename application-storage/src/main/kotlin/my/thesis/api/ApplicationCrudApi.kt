package my.thesis.api

import my.thesis.model.response.ApplicationResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
@RequestMapping("/application")
interface ApplicationCrudApi {

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["{id}"],
        produces = ["application/json"]
    )
    fun getApplication(@PathVariable("id") id: String): ResponseEntity<ApplicationResponse>
}