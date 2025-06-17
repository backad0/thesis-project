package my.thesis.dal.impl

import my.thesis.dal.ApplicationDal
import my.thesis.mapper.mapResponseToApplication
import my.thesis.model.integration.Application
import my.thesis.model.integration.request.CreateApplicationData
import my.thesis.model.integration.response.UpdateApplicationData
import my.thesis.rest.ApplicationStorageClient

class ApplicationDalImpl(
    private val applicationStorageClient: ApplicationStorageClient
) : ApplicationDal {
    override fun getApplication(applicationId: String): Application {
        return mapResponseToApplication(
            applicationStorageClient.getApplication(applicationId)
        )
    }
}