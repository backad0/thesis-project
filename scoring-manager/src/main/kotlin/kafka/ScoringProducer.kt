package kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

class ScoringProducer(
    private val producerFactory: ProducerFactory<String, Any>
) {
    fun sendAccountCreationMessage(result: Boolean) {
        KafkaTemplate(producerFactory).apply {
            defaultTopic = "score-application"
        }.sendDefault(result)
    }
}