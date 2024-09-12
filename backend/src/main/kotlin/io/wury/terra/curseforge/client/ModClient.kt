package io.wury.terra.curseforge.client

import io.wury.terra.curseforge.representation.request.GetFeaturedModsRequest
import io.wury.terra.curseforge.representation.request.GetModsRequest
import io.wury.terra.curseforge.representation.request.SearchModsRequest
import io.wury.terra.curseforge.representation.response.*
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono
import kotlin.reflect.full.declaredMemberProperties

@Service
class ModClient(
    private val client: WebClient,
) {
    fun getMod(modId: Long): Mono<GetModResponse> {
        return client.get().uri("/mods/$modId").retrieve().bodyToMono()
    }

    fun getMods(modIds: List<Int>, filterPcOnly: Boolean? = null): Mono<GetModsResponse> {
        return client.post().uri("/mods").bodyValue(GetModsRequest(modIds, filterPcOnly)).retrieve().bodyToMono()
    }

    fun searchMods(request: SearchModsRequest): Mono<SearchModsResponse> {
        val uri = "/search?gameId=${request.gameId}"
        return client.get()
            .uri {
                it.path("/search")
                SearchModsRequest::class.declaredMemberProperties.forEach { prop ->
                    val name = prop.name
                    val value = prop.get(request).toString()
                    if (value.isNotBlank()) {
                        it.queryParam(name, value)
                    }
                }
                it.build()
            }
            .retrieve().bodyToMono()
    }

    fun getFeaturedMods(request: GetFeaturedModsRequest): Mono<GetFeaturedModsResponse> {
        return client.post()
            .uri("featured")
            .bodyValue(request)
            .retrieve()
            .bodyToMono()
    }

    fun getModDescription(modId: Long): Mono<StringResponse> {
        return client.get()
            .uri("mods/$modId/description")
            .retrieve()
            .bodyToMono()
    }
}