package my.thesis.model.integration

import java.util.UUID

data class FinalDecision(
    val id: UUID,
    val offers: List<Offer>,
    val decision: String
)
