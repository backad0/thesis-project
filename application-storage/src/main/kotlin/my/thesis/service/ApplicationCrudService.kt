package my.thesis.service

import my.thesis.model.Application

interface ApplicationCrudService {

    fun getApplication(id: String): Application
}