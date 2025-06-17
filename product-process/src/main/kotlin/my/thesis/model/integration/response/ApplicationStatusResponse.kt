package my.thesis.model.integration.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import java.util.UUID

data class ApplicationStatusResponse(
    @JsonProperty("id", required = true)val id: UUID,
    @JsonProperty("status", required = true) val status: String,
    @JsonProperty("createdAt", required = true)val createdAt: LocalDateTime,
    @JsonProperty("updatedAt", required = true)val updatedAt: LocalDateTime
)
