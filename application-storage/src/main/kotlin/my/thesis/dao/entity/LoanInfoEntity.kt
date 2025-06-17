package my.thesis.dao.entity

import java.math.BigDecimal
import java.util.UUID

data class LoanInfoEntity(
    val id: UUID,
    val amount: BigDecimal,
    val term: Int,
    val interestRate: BigDecimal,
)