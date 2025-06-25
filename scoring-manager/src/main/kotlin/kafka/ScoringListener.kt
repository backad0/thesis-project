package kafka

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component
import service.ScoringService

@Component
class ScoringListener(
    private val scoringService: ScoringService,
) {

    @KafkaListener(
        topics = ["score-application"],
        groupId = "score-application.0",
        containerFactory = "kafkaListenerContainerFactory"
    )
    fun processMessage(
        applicationId: String,
        acknowledgment: Acknowledgment,
    ) {
        scoringService.scoreApplication(applicationId)

        acknowledgment.acknowledge()
    }
}