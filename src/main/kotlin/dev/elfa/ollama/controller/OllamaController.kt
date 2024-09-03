package dev.elfa.ollama.controller

import dev.elfa.ollama.service.OllamaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class OllamaController(private val ollamaService: OllamaService) {

    @PostMapping("/ask")
    fun askOllama(@RequestBody userPrompt: String): ResponseEntity<String> {
        val response = ollamaService.askOllama(userPrompt)

        return ResponseEntity.ok(response)
    }
}
