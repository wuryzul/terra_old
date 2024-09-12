package io.wury.terra.curseforge.client

import io.wury.terra.curseforge.representation.request.GetFeaturedModsRequest
import io.wury.terra.curseforge.representation.request.GetModsRequest
import io.wury.terra.curseforge.representation.request.SearchModsRequest
import io.wury.terra.curseforge.representation.response.GetFeaturedModsResponse
import io.wury.terra.curseforge.representation.response.GetModResponse
import io.wury.terra.curseforge.representation.response.GetModsResponse
import io.wury.terra.curseforge.representation.response.SearchModsResponse
import io.wury.terra.curseforge.representation.response.StringResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono
import kotlin.reflect.full.declaredMemberProperties

@Service
class ModClient(
    private val client: WebClient,
) {
    fun getMod(modId: Int): Mono<GetModResponse> {
        return client.get().uri("/mods/$modId").retrieve().bodyToMono()
    }

    fun getMods(modIds: List<Int>, filterPcOnly: Boolean? = null): Mono<GetModsResponse> {
        return client.post().uri("/mods").bodyValue(GetModsRequest(modIds, filterPcOnly)).retrieve().bodyToMono()
    }

    fun searchMods(request: SearchModsRequest): Mono<SearchModsResponse> {
        return client.get()
            .uri {
                SearchModsRequest::class.declaredMemberProperties
                    .associate { prop -> prop.name to prop.get(request)?.toString() }.entries
                    .filter { (_, value) -> value!=null }
                    .fold(it.path("/mods/search").queryParam("gameId", request.gameId)) { builder, prop ->
                        prop.let { (name, value) -> builder.queryParam(name, value) }
                    }.also { println("uri: ${it.toUriString()}") }.build()
            }
            .retrieve()
            .bodyToMono()
    }

    fun getFeaturedMods(request: GetFeaturedModsRequest): Mono<GetFeaturedModsResponse> {
        return client.post()
            .uri("featured")
            .bodyValue(request)
            .retrieve()
            .bodyToMono()
    }

    fun getModDescription(modId: Int): Mono<StringResponse> {
        return client.get()
            .uri("/mods/$modId/description")
            .retrieve()
            .bodyToMono()
    }
}