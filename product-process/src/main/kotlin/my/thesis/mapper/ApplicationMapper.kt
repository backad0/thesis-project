package my.thesis.mapper

import my.thesis.model.*
import my.thesis.model.integration.Application
import my.thesis.model.integration.ApplicationStatus
import my.thesis.model.integration.FinalDecision
import my.thesis.model.integration.LoanInfo
import my.thesis.model.integration.Offer
import my.thesis.model.integration.PassportInfo
import my.thesis.model.integration.PersonInfo
import my.thesis.model.integration.response.ApplicationResponse
import my.thesis.model.integration.response.ApplicationStatusResponse
import my.thesis.model.integration.response.FinalDecisionResponse
import my.thesis.model.integration.response.LoanInfoResponse
import my.thesis.model.integration.response.OfferResponse
import my.thesis.model.integration.response.PassportInfoResponse
import my.thesis.model.integration.response.PersonInfoResponse

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

// From Response mappers
fun mapResponseToApplication(response: ApplicationResponse): Application {
    return Application(
        id = response.id,
        personInfo = mapResponseToPersonInfo(response.personInfo),
        loanInfo = mapResponseToLoanInfo(response.loanInfo),
        status = mapResponseToStatus(response.status),
        decision = response.decision?.let { mapResponseToDecision(it) }
    )
}

fun mapResponseToLoanInfo(response: LoanInfoResponse): LoanInfo {
    return LoanInfo(
        id = response.id,
        amount = response.amount,
        term = response.term,
        interestRate = response.interestRate
    )
}

fun mapResponseToStatus(response: ApplicationStatusResponse): ApplicationStatus {
    return ApplicationStatus(
        id = response.id,
        status = response.status,
        createdAt = response.createdAt,
        updatedAt = response.updatedAt
    )
}

fun mapResponseToDecision(response: FinalDecisionResponse): FinalDecision {
    return FinalDecision(
        id = response.id,
        offers = response.offers.map { mapResponseToOffer(it) },
        decision = response.decision
    )
}

fun mapResponseToOffer(response: OfferResponse): Offer {
    return Offer(
        id = response.id,
        applicationId = response.applicationId,
        amount = response.amount,
        term = response.term,
        interestRate = response.interestRate
    )
}

fun mapResponseToPersonInfo(response: PersonInfoResponse): PersonInfo {
    return PersonInfo(
        id = response.id,
        email = response.email,
        phone = response.phone,
        firstName = response.firstName,
        lastName = response.lastName,
        birthDate = response.birthDate,
        passportInfo = mapResponseToPassportInfo(response.passportInfo)
    )
}

fun mapResponseToPassportInfo(response: PassportInfoResponse): PassportInfo {
    return PassportInfo(
        id = response.id,
        series = response.series,
        number = response.number,
        issuedBy = response.issuedBy,
        issuedDate = response.issuedDate
    )
}