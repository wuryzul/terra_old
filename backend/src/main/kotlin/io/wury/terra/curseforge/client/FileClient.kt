package io.wury.terra.curseforge.client

import io.wury.terra.curseforge.representation.response.GetFileResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class FileClient(
    private val webClient: WebClient,
) {
    suspend fun getFile(modId: Int, fileId: Int): GetFileResponse {
        return webClient.get().uri("/mods/$modId/files/$fileId").retrieve().awaitBody()
    }
}