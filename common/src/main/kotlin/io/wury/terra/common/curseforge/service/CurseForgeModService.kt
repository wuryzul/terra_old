package io.wury.terra.common.curseforge.service

import io.wury.terra.common.core.model.ModModel
import io.wury.terra.common.curseforge.model.mapper.CurseForgeModMapper
import io.wury.terra.common.curseforge.representation.response.GetModResponse
import io.wury.terra.common.curseforge.representation.response.SearchModsResponse
import io.wury.terra.common.curseforge.representation.response.StringResponse
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class CurseForgeModService(
    @Qualifier("curse-forge-web-client")
    private val webClient: WebClient,
    private val curseForgeModMapper: CurseForgeModMapper,
) {
    suspend fun getMod(modId: Int): ModModel {
        return curseForgeModMapper.convert(
            webClient.get()
                .uri("/mods/$modId")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .awaitBody<GetModResponse>()
                .data
        )
    }

    suspend fun getMod(slug: String): ModModel {
        return curseForgeModMapper.convert(
            webClient.get()
                .uri("/mods/search?gameId=432&slug=$slug")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .awaitBody<SearchModsResponse>()
                .data
                .single()
        )
    }

    suspend fun getModDescription(modId: Int): String {
        return webClient.get()
            .uri("/mods/$modId/description")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .awaitBody<StringResponse>()
            .data
    }
}