package my.thesis.controller

import my.thesis.StatusBroadcaster
import my.thesis.model.CreditRequest
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@RestController
@RequestMapping("/frontend-api")
class KafkaController(
    private val kafkaTemplate: KafkaTemplate<String, CreditRequest>,
    private val statusBroadcaster: StatusBroadcaster
) {
    @PostMapping("/send")
    fun send(@RequestBody request: CreditRequest): ResponseEntity<Void> {
        kafkaTemplate.send("product-process.start", request)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/status", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun streamStatus(): SseEmitter {
        val emitter = SseEmitter()
        statusBroadcaster.addEmitter(emitter)
        return emitter
    }
}