package my.thesis.dal

import my.thesis.model.integration.Application

interface ApplicationDal {
    fun getApplication(applicationId: String): Application
}



//    fun createApplication(request: CreateApplicationData): String
//    fun updateApplication(request: UpdateApplicationData): Application