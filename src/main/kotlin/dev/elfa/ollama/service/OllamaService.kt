package dev.elfa.ollama.service

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.prompt.ChatOptionsBuilder
import org.springframework.stereotype.Service

@Service
class OllamaService internal constructor(chatClientBuilder: ChatClient.Builder) {
    private val chatClient: ChatClient = chatClientBuilder.defaultOptions(
        ChatOptionsBuilder.builder()
            .withTemperature(0.9f)
            .build()
    ).build()

    fun askOllama(userPrompt: String): String {
        return chatClient.prompt()
            .system("You are an assistant that answers questions using only the provided context.")
            .user(userPrompt)
            .call()
            .content()
    }
}
