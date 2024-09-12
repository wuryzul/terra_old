package io.wury.terra.core.service

import io.wury.terra.core.mapper.ModEntityToModelMapper
import io.wury.terra.core.mapper.ModModelToEntityMapper
import io.wury.terra.core.model.ModModel
import io.wury.terra.curseforge.client.ModClient
import io.wury.terra.curseforge.mapper.CurseForgeMapper
import io.wury.terra.curseforge.representation.request.SearchModsRequest
import io.wury.terra.db.entity.ModEntity
import io.wury.terra.db.repository.ModRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono

@Service
class ModService(
    private val modRepository: ModRepository,
    private val modClient: ModClient,
    private val curseForgeMapper: CurseForgeMapper,
    private val modEntityToModelMapper: ModEntityToModelMapper,
    private val modModelToEntityMapper: ModModelToEntityMapper,
) {
    private fun Mono<ModEntity>.toModel(): Mono<ModModel> =
        map(modEntityToModelMapper::convert)

    private fun Flux<ModEntity>.toModel(): Flux<ModModel> =
        map(modEntityToModelMapper::convert)

    fun getModFromCurseForge(curseForgeID: Long): Mono<ModModel> {
        return modClient.getMod(curseForgeID)
            .map { curseForgeMapper.mapMod(it.data) }
            .flatMap { createMod(it) }
    }

    fun getModFromCurseForge(slug: String): Mono<ModModel> {
        return modClient.searchMods(SearchModsRequest(gameId = 432, slug = slug))
            .map { it.data.single() }
            .map(curseForgeMapper::mapMod)
            .flatMap(::createMod)
    }

    fun createMod(mod: ModModel): Mono<ModModel> = modRepository.save(modModelToEntityMapper.convert(mod)).toModel()

    fun getAllMods(): Flux<ModModel> = modRepository.findAll().toModel()

    fun getMods(modIds: List<Long>): Flux<ModModel> =
        modIds.toFlux().flatMap { getModByCurseForgeID(it) }


    fun getModById(id: Long): Mono<ModModel> = modRepository.findById(id).toModel()

    fun getModByCurseForgeID(curseForgeID: Long): Mono<ModModel> =
        modRepository.findByCurseForgeID(curseForgeID).toModel().switchIfEmpty { getModFromCurseForge(curseForgeID) }

    fun getModBySlug(slug: String): Mono<ModModel> = modRepository.findBySlug(slug).toModel().switchIfEmpty { getModFromCurseForge(slug) }
}