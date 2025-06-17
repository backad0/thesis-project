package my.thesis.model

import java.time.LocalDate
import java.util.UUID

data class PersonInfo(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val birthDate: LocalDate,
    val email: String?,
    val phone: String?,
    val passportInfo: PassportInfo
)
