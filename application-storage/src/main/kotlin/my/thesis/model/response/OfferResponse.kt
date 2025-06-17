package my.thesis.model.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.util.UUID

data class OfferResponse(
    @JsonProperty("id", required = true) val id: UUID,
    @JsonProperty("applicationId", required = true) val applicationId: UUID,
    @JsonProperty("amount", required = true) val amount: BigDecimal,
    @JsonProperty("term", required = true) val term: Int,
    @JsonProperty("interestRate", required = true) val interestRate: Float
)
