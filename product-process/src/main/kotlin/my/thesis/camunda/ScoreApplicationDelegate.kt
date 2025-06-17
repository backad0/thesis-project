package my.thesis.camunda

import my.thesis.service.ProductProcessService
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class ScoreApplicationDelegate(
    private val productProcessService: ProductProcessService
) : JavaDelegate {
    override fun execute(execution: DelegateExecution) {
        val applicationId = execution.getVariable(APPLICATION_ID) as String

        val scoringResult = productProcessService.scoreApplication(applicationId)

        execution.setVariable(IS_SCORING_RESULT_TRUE, scoringResult)
    }
}