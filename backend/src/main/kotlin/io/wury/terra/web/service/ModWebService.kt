package io.wury.terra.web.service

import io.wury.terra.core.model.ModModel
import io.wury.terra.core.service.ModService
import io.wury.terra.web.mapper.GetModResponseMapper
import io.wury.terra.web.representation.request.GetModsRequest
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
    fun Mono<ModModel>.toResponse(): Mono<GetModResponse> =
        map(getModResponseMapper::convert)

    fun Flux<ModModel>.toResponse(): Mono<GetModsResponse> =
        map(getModResponseMapper::convert).collectList()
            .map { GetModsResponse(it) }

    fun getAllMods(): Mono<GetModsResponse> {
        return modService.getAllMods().toResponse()
    }

    fun getMods(request: GetModsRequest): Mono<GetModsResponse> {
        return modService.getMods(request.modIds).toResponse()
    }

    fun getModById(id: Long): Mono<GetModResponse> {
        return modService.getModById(id).toResponse()
    }

    fun getModByCurseForgeID(curseForgeID: Long): Mono<GetModResponse> {
        return modService.getModByCurseForgeID(curseForgeID).toResponse()
    }

    fun getModBySlug(slug: String): Mono<GetModResponse> {
        return modService.getModBySlug(slug).toResponse()
    }
}