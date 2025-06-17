package my.thesis.model

import java.time.LocalDate
import java.util.UUID

data class PassportInfo(
    val id: UUID,
    val series: String,
    val number: String,
    val issuedBy: String,
    val issuedDate: LocalDate
)
