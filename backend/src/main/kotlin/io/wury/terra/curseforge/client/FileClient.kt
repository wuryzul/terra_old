package io.wury.terra.curseforge.client

import io.wury.terra.curseforge.representation.response.GetFileResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@Service
class FileClient(
    private val webClient: WebClient,
) {
    fun getFile(modId: Int, fileId: Int): Mono<GetFileResponse> {
        return webClient.get().uri("/mods/$modId/files/$fileId").retrieve().bodyToMono()
    }
}