package my.thesis.model

import java.math.BigDecimal
import java.util.UUID

data class LoanInfo(
    val id: UUID,
    val amount: BigDecimal,
    val term: Int,
    val interestRate: BigDecimal
)
