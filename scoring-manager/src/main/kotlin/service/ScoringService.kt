package service

interface ScoringService {

    fun scoreApplication(applicationId: String): Boolean
}