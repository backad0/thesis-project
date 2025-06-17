package my.thesis.model.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class FinalDecisionResponse(
    @JsonProperty("id", required = true) val id: UUID,
    @JsonProperty("offers", required = true) val offers: List<OfferResponse>,
    @JsonProperty("decision", required = true) val decision: String
)
