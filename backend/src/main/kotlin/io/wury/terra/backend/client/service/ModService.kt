package io.wury.terra.backend.client.service

import io.wury.terra.backend.client.representation.mapper.ClientGetModResponseMapper
import io.wury.terra.common.core.model.ModModel
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class ModService(
    private val webClient: WebClient,
    private val getModResponseMapper: ClientGetModResponseMapper,
) {
    suspend fun getMod(modId: Int): ModModel {
        return getModResponseMapper.convert(
            webClient.get().uri("/mod/$modId").accept(MediaType.APPLICATION_JSON).retrieve().awaitBody()
        )
    }

    suspend fun getMod(slug: String): ModModel {
        return getModResponseMapper.convert(
            webClient.get().uri("/mod/slug/$slug").accept(MediaType.APPLICATION_JSON).retrieve().awaitBody()
        )
    }
}