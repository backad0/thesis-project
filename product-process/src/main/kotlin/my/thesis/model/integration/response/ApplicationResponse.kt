package my.thesis.model.integration.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class ApplicationResponse (
    @JsonProperty("id", required = true) val id: UUID,
    @JsonProperty("personInfo", required = true) val personInfo: PersonInfoResponse,
    @JsonProperty("loanInfo", required = true) val loanInfo: LoanInfoResponse,
    @JsonProperty("status", required = true) val status: ApplicationStatusResponse,
    @JsonProperty("decision", required = false) val decision: FinalDecisionResponse?
)