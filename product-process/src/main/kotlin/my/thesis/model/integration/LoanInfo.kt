package my.thesis.model.integration

import java.math.BigDecimal
import java.util.UUID

data class LoanInfo(
    val id: UUID,
    val amount: BigDecimal,
    val term: Int,
    val interestRate: Float
)
