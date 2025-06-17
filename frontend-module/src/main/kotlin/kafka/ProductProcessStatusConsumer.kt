package my.thesis.kafka

import my.thesis.StatusBroadcaster
import org.springframework.kafka.annotation.KafkaListener

class ProductProcessStatusConsumer(
    private val statusBroadcaster: StatusBroadcaster
) {
    @KafkaListener(
        topics = ["product-process.status.notification"],
        groupId = "frontend-module")
    fun consume(result: String) {
        val status = when {
            "APPROVED" in result.uppercase() -> "APPROVED"
            "REJECTED" in result.uppercase() -> "REJECTED"
            else -> "UNKNOWN"
        }
        statusBroadcaster.broadcast(status)
    }
}