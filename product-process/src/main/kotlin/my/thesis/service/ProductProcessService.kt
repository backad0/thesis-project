package my.thesis.service

import my.thesis.model.StartApplicationData

interface ProductProcessService {
    fun startApplication(data: StartApplicationData)
    fun scoreApplication(
        applicationId: String
    ): Boolean
    fun sendAccountCreationMessage(applicationId: String)
    fun processAccountCreationMessage(applicationId: String)
    fun sendProductProcessEndedNotification(applicationId: String)
}