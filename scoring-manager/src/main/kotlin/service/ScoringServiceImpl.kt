package service

import client.ApplicationStorageClient
import client.BciClient

class ScoringServiceImpl(
    private val applicationStorageClient: ApplicationStorageClient,
    private val bciClient: BciClient
) : ScoringService {

    override fun scoreApplication(applicationId: String): Boolean {
        val application = applicationStorageClient.getApplication(applicationId)

        val clientData = bciClient.getCreditHistory(mapToClientData(application))

        var score = 0

        score += when (clientData.delinquencies) {
            0 -> 30
            in 1..2 -> 10
            in 3..5 -> -10
            else -> -30
        }

        score += when {
            clientData.debtRatio < 0.2 -> 20
            clientData.debtRatio < 0.4 -> 0
            clientData.debtRatio < 0.6 -> -15
            else -> -25
        }

        score += when {
            clientData.employmentLength > 3 -> 15
            clientData.employmentLength > 1 -> 5
            else -> -10
        }

        val loanToIncome = clientData.loanAmount / clientData.annualIncome
        score += when {
            loanToIncome < 0.5 -> 20
            loanToIncome < 1.0 -> 0
            else -> -20
        }

        score += when {
            clientData.loanTerm < 12 -> 10
            clientData.loanTerm <= 36 -> 0
            else -> -10
        }

        score += if (age in 25..60) 5 else -5

        return score > 50
    }
}