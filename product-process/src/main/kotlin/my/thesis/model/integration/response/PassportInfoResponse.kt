package my.thesis.model.integration.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.util.UUID

data class PassportInfoResponse(
    @JsonProperty("id", required = true) val id: UUID,
    @JsonProperty("series", required = true) val series: String,
    @JsonProperty("number", required = true) val number: String,
    @JsonProperty("issuedBy", required = true) val issuedBy: String,
    @JsonProperty("issuedDate", required = true) val issuedDate: LocalDate
)
