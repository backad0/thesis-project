package my.thesis.model.integration

import java.math.BigDecimal
import java.util.UUID

data class Offer(
    val id: UUID,
    val applicationId: UUID,
    val amount: BigDecimal,
    val term: Int,
    val interestRate: Float
)
