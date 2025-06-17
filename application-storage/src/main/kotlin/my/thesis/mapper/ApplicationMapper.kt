package my.thesis.mapper

import my.thesis.model.*
import my.thesis.model.response.*

fun mapApplicationToResponse(application: Application): ApplicationResponse {
    return ApplicationResponse(
        id = application.id,
        personInfo = mapPersonInfoResponse(application.personInfo),
        loanInfo = mapLoanInfoResponse(application.loanInfo),
        status = mapStatusResponse(application.status),
        decision = mapDecisionResponse(application.decision),
    )
}

fun mapLoanInfoResponse(loanInfo: LoanInfo): LoanInfoResponse {
    return LoanInfoResponse(
        id = loanInfo.id,
        amount = loanInfo.amount,
        term = loanInfo.term,
        interestRate = loanInfo.interestRate,
    )
}

fun mapStatusResponse(status: ApplicationStatus): ApplicationStatusResponse {
    return ApplicationStatusResponse(
        id = status.id,
        status = status.status,
        createdAt = status.createdAt,
        updatedAt = status.updatedAt
    )
}

fun mapDecisionResponse(decision: FinalDecision?): FinalDecisionResponse? {
    return decision?.let {
        FinalDecisionResponse(
            id = it.id,
            offers = it.offers.map { offer -> mapOfferResponse(offer) },
            decision = it.decision
        )
    }
}

fun mapOfferResponse(offer: Offer): OfferResponse {
    return OfferResponse(
        id = offer.id,
        applicationId = offer.applicationId,
        amount = offer.amount,
        term = offer.term,
        interestRate = offer.interestRate
    )
}

fun mapPersonInfoResponse(personInfo: PersonInfo): PersonInfoResponse {
    return PersonInfoResponse(
        id = personInfo.id,
        email = personInfo.email,
        phone = personInfo.phone,
        firstName = personInfo.firstName,
        lastName = personInfo.lastName,
        birthDate = personInfo.birthDate,
        passportInfo = mapPassportInfoResponse(personInfo.passportInfo)
    )
}

fun mapPassportInfoResponse(passportInfo: PassportInfo): PassportInfoResponse {
    return PassportInfoResponse(
        id = passportInfo.id,
        series = passportInfo.series,
        number = passportInfo.number,
        issuedBy = passportInfo.issuedBy,
        issuedDate = passportInfo.issuedDate
    )
}