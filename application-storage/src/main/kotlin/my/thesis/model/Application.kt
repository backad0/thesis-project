package my.thesis.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class Application(
    val id: UUID,
    val personInfo: PersonInfo,
    val loanInfo: LoanInfo,
    val status: ApplicationStatus,
    val decision: FinalDecision?
)
