package my.thesis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FrontendModuleApplication

fun main(args: Array<String>) {
    runApplication<FrontendModuleApplication>(*args)
}