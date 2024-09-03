package dev.elfa.ollama

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OllamaApplication

fun main(args: Array<String>) {
    runApplication<OllamaApplication>(*args)
}
