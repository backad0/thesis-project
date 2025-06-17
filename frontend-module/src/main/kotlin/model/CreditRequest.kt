package my.thesis.model

import java.math.BigDecimal
import java.time.LocalDate

data class CreditRequest(
    val firstName: String,
    val lastName: String,
    val birthDate: LocalDate,
    val email: String,
    val phone: String,
    val passportNumber: String,
    val passportIssueDate: LocalDate,
    val passportIssuedBy: String,

    val amount: BigDecimal,
    val term: Int,
    val rate: BigDecimal
)