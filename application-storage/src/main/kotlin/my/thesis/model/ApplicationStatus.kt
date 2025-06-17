package my.thesis.model

import java.time.LocalDateTime
import java.util.UUID

data class ApplicationStatus(
    val id: UUID,
    val status: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
