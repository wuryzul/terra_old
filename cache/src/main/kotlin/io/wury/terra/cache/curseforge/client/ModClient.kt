package io.wury.terra.cache.curseforge.client

import io.wury.terra.cache.curseforge.representation.request.GetFeaturedModsRequest
import io.wury.terra.cache.curseforge.representation.request.GetModsRequest
import io.wury.terra.cache.curseforge.representation.request.SearchModsRequest
import io.wury.terra.cache.curseforge.representation.response.GetFeaturedModsResponse
import io.wury.terra.cache.curseforge.representation.response.GetModResponse
import io.wury.terra.cache.curseforge.representation.response.GetModsResponse
import io.wury.terra.cache.curseforge.representation.response.SearchModsResponse
import io.wury.terra.cache.curseforge.representation.response.StringResponse
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import kotlin.reflect.full.declaredMemberProperties

@Service
class ModClient(
    @Qualifier("curse-forge-web-client")
    private val client: WebClient,
) {
    suspend fun getMod(modId: Int): GetModResponse {
        return client.get().uri("/mods/$modId").retrieve().awaitBody()
    }

    suspend fun getMods(modIds: List<Int>, filterPcOnly: Boolean? = null): GetModsResponse {
        return client.post().uri("/mods").bodyValue(
            GetModsRequest(
                modIds,
                filterPcOnly
            )
        ).retrieve().awaitBody()
    }

    suspend fun searchMods(request: SearchModsRequest): SearchModsResponse {
        return client.get()
            .uri {
                SearchModsRequest::class.declaredMemberProperties
                    .associate { prop -> prop.name to prop.get(request)?.toString() }.entries
                    .filter { (_, value) -> value != null }
                    .fold(it.path("/mods/search").queryParam("gameId", request.gameId)) { builder, prop ->
                        prop.let { (name, value) -> builder.queryParam(name, value) }
                    }.build()
            }
            .retrieve()
            .awaitBody()
    }

    suspend fun getFeaturedMods(request: GetFeaturedModsRequest): GetFeaturedModsResponse {
        return client.post()
            .uri("featured")
            .bodyValue(request)
            .retrieve()
            .awaitBody()
    }

    suspend fun getModDescription(modId: Int): StringResponse {
        return client.get()
            .uri("/mods/$modId/description")
            .retrieve()
            .awaitBody()
    }
}