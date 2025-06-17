package my.thesis.model.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.util.UUID

data class PersonInfoResponse(
    @JsonProperty("id", required = true) val id: UUID,
    @JsonProperty("firstName", required = true) val firstName: String,
    @JsonProperty("lastName", required = true) val lastName: String,
    @JsonProperty("birthDate", required = true) val birthDate: LocalDate,
    @JsonProperty("email", required = false) val email: String?,
    @JsonProperty("phone", required = false) val phone: String?,
    @JsonProperty("passportInfo", required = true) val passportInfo: PassportInfoResponse
)
