package io.wury.terra.common.client.service

import io.wury.terra.common.client.representation.mapper.ClientGetFileResponseMapper
import io.wury.terra.common.core.model.FileModel
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class ClientFileService(
    @Qualifier("curse-forge-web-client")
    private val webClient: WebClient,
    private val getFileResponseMapper: ClientGetFileResponseMapper,
) {
    suspend fun getFile(modId: Int, fileId: Int): FileModel {
        return getFileResponseMapper.convert(
            webClient.get().uri("/mod/$modId/file/$fileId").accept(MediaType.APPLICATION_JSON).retrieve().awaitBody()
        )
    }
}