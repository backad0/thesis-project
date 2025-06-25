package my.thesis.kafka.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import my.thesis.dal.ApplicationDal
import my.thesis.mapper.mapStartApplicationData
import my.thesis.model.kafka.StartApplicationMessage
import my.thesis.service.ProductProcessService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component

@Component
class ProductProcessStartListener(
    private val objectMapper: ObjectMapper,
    private val productProcessService: ProductProcessService,
    private val dal: ApplicationDal
) {

    @KafkaListener(
        topics = ["product-process.start"],
        groupId = "product-process.start.0",
        containerFactory = "kafkaListenerContainerFactory"
    )
    fun onMessage(
        message: String,
        acknowledgment: Acknowledgment,
    ) {
        val receivedMessage = try {
            objectMapper.readValue(message, StartApplicationMessage::class.java)
        } catch (ex: Exception) {
            throw IllegalStateException("wrong message")
        }
        productProcessService.startApplication(mapStartApplicationData(receivedMessage))
        acknowledgment.acknowledge()
    }
}