package my.thesis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductProcessApplication

fun main(args: Array<String>) {
    runApplication<ProductProcessApplication>(*args)
}