package io.wury.terra.common.client.service

import io.wury.terra.common.client.representation.mapper.ClientGetFileResponseMapper
import io.wury.terra.common.model.FileModel
import io.wury.terra.common.web.representation.response.GetFileResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class ClientFileService(
    @Qualifier("terra-web-client")
    @Autowired(required = false)
    private val webClient: WebClient? = null,
    private val getFileResponseMapper: ClientGetFileResponseMapper,
) {
    suspend fun getFile(modId: Int, fileId: Int): FileModel? {
        return webClient?.get()
            ?.uri("/mod/$modId/file/$fileId")
            ?.accept(MediaType.APPLICATION_JSON)
            ?.retrieve()?.awaitBody<GetFileResponse>()
            ?.let(getFileResponseMapper::convert)
    }
}