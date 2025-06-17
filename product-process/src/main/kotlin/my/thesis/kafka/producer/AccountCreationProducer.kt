package my.thesis.kafka.producer

import my.thesis.model.kafka.AccountCreationMessage
import org.apache.kafka.clients.producer.KafkaProducer
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

class AccountCreationProducer(
    private val producerFactory: ProducerFactory<String, Any>
){
    fun sendAccountCreationMessage(message: AccountCreationMessage) {
        KafkaTemplate(producerFactory).apply {
            defaultTopic = "account-creation"
        }.sendDefault(message)
    }
}