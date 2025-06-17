package my.thesis.model

import java.util.UUID

data class FinalDecision(
    val id: UUID,
    val offers: List<Offer>,
    val decision: String
)
