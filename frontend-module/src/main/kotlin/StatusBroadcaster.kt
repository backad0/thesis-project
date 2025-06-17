package my.thesis

import org.springframework.stereotype.Component
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.concurrent.CopyOnWriteArrayList

@Component
class StatusBroadcaster {
    private val emitters = CopyOnWriteArrayList<SseEmitter>()

    fun addEmitter(emitter: SseEmitter) {
        emitters.add(emitter)
        emitter.onCompletion { emitters.remove(emitter) }
        emitter.onTimeout { emitters.remove(emitter) }
    }

    fun broadcast(status: String) {
        val json = """{ "status": "$status" }"""
        val event = SseEmitter.event().data(json)
        emitters.forEach {
            try { it.send(event) } catch (_: Exception) {}
        }
    }
}
