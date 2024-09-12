package io.wury.terra.web.service

import io.wury.terra.core.model.ModModel
import io.wury.terra.core.service.ModService
import io.wury.terra.curseforge.client.ModClient
import io.wury.terra.curseforge.mapper.CurseForgeMapper
import io.wury.terra.web.mapper.GetModResponseMapper
import io.wury.terra.web.representation.response.GetModResponse
import io.wury.terra.web.representation.response.GetModsResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ModWebService(
    private val modService: ModService,
    private val modClient: ModClient,
    private val curseForgeMapper: CurseForgeMapper,
    private val getModResponseMapper: GetModResponseMapper,
) {
    fun getAllMods(): Mono<GetModsResponse> {
        return modService.getAllMods()
            .map { getModResponseMapper.convert(it) }
            .collectList()
            .map { GetModsResponse(it) }
    }

    fun getModFromCurseForge(curseForgeID: Long): Mono<ModModel> {
        return modClient.getMod(curseForgeID)
            .map { curseForgeMapper.mapMod(it.data) }
            .flatMap { modService.createMod(it) }
    }

    fun getModById(id: Long): Mono<GetModResponse> {
        return modService.getModById(id)
            .map { getModResponseMapper.convert(it) }
    }

    fun getModByCurseForgeID(curseForgeID: Long): Mono<GetModResponse> {
        return modService.getModByCurseForgeID(curseForgeID)
            .switchIfEmpty(getModFromCurseForge(curseForgeID))
            .map { getModResponseMapper.convert(it) }
    }
}