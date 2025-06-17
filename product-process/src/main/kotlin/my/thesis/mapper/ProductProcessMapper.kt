package my.thesis.mapper

import my.thesis.model.StartApplicationData
import my.thesis.model.kafka.StartApplicationMessage

fun mapStartApplicationData(message: StartApplicationMessage): StartApplicationData {
    return StartApplicationData()
}