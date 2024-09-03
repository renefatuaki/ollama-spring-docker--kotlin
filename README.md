# Olllama integration with Spring Boot and Docker

## 💡 About

This demo project shows how Ollama can be integrated into a Spring Boot application using Docker Compose.
It shows how to configure a Ollama instance within a containerized environment.

## ⚙️ Setup

### Ollama Configuration

The Ollama integration in Spring AI is initially configured to connect to a local Ollama instance, accessible via http://localhost:11434.
For our specific scenario, the base URL has been predefined in the `.env` file to target the Docker container’s network address.
The environment variable **LLM** is currently set to **Mistral** within the `.env` file,
but it can be modified to reference any other language model available in the [Ollama library](https://ollama.com/library).

#### GPU Support

Uncomment the following lines in `compose.yaml` to enable GPU support:

```yaml
deploy:
  resources:
    reservations:
      devices:
        - driver: nvidia
          count: all
          capabilities: [ gpu ]
```

For more details, refer to the Docker documentation
on [enabling GPU access.](https://docs.docker.com/compose/gpu-support/#enabling-gpu-access-to-service-containers).

### Starting the Application

```sh
docker-compose up --build
```

**Note:** The build process may take several minutes, as Ollama will download and install the Mistral LLM during the initial setup.

## 🔌 API

The application provides a single endpoint for interacting with the Ollama language model:

### POST /api/ask

```sh
curl -X POST http://localhost:8080/api/ask -H "Content-Type: text/plain" -d "Your prompt here"
```

## 📚 Resources

* https://hub.docker.com/r/ollama/ollama
* https://docs.docker.com/compose/gpu-support/
* https://docs.spring.io/spring-ai/reference/api/chat/ollama-chat.html