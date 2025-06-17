package my.thesis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApplicationStorageApplication

fun main(args: Array<String>) {
    runApplication<ApplicationStorageApplication>(*args)
}