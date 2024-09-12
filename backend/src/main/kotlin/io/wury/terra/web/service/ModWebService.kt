package io.wury.terra.web.service

import io.wury.terra.core.model.ModModel
import io.wury.terra.core.service.ModService
import io.wury.terra.web.mapper.GetModResponseMapper
import io.wury.terra.web.representation.request.GetModsRequest
import io.wury.terra.web.representation.response.GetModDescriptionResponse
import io.wury.terra.web.representation.response.GetModResponse
import io.wury.terra.web.representation.response.GetModsResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ModWebService(
    private val modService: ModService,
    private val getModResponseMapper: GetModResponseMapper,
) {
    fun Mono<ModModel>.toGetModResponse(): Mono<GetModResponse> =
        map(getModResponseMapper::convert)

    fun Flux<ModModel>.toGetModsResponse(): Mono<GetModsResponse> =
        map(getModResponseMapper::convert).collectList()
            .map { GetModsResponse(it) }

    fun Mono<String>.toGetModDescriptionResponse(): Mono<GetModDescriptionResponse> =
        map { GetModDescriptionResponse(it) }

    fun getAllMods(): Mono<GetModsResponse> {
        return modService.getAllMods().toGetModsResponse()
    }

    fun getMods(request: GetModsRequest): Mono<GetModsResponse> {
        return modService.getMods(request.modIds).toGetModsResponse()
    }

    fun getModById(id: Long): Mono<GetModResponse> {
        return modService.getModById(id).toGetModResponse()
    }

    fun getModByCurseForgeID(curseForgeID: Long): Mono<GetModResponse> {
        return modService.getModByCurseForgeID(curseForgeID).toGetModResponse()
    }

    fun getModBySlug(slug: String): Mono<GetModResponse> {
        return modService.getModBySlug(slug).toGetModResponse()
    }

    fun getModDescription(modId: Long): Mono<GetModDescriptionResponse> {
        return modService.getModDescription(modId).toGetModDescriptionResponse()
    }

    fun getModDescriptionByCurseForgeID(curseForgeID: Long): Mono<GetModDescriptionResponse> {
        return modService.getModDescriptionByCurseForgeID(curseForgeID).toGetModDescriptionResponse()
    }

    fun getModDescriptionBySlug(slug: String): Mono<GetModDescriptionResponse> {
        return modService.getModDescriptionBySlug(slug).toGetModDescriptionResponse()
    }
}