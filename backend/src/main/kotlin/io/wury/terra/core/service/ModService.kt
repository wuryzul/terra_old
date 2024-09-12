package io.wury.terra.core.service

import io.wury.terra.core.mapper.ModEntityToModelMapper
import io.wury.terra.core.mapper.ModModelToEntityMapper
import io.wury.terra.core.model.ModModel
import io.wury.terra.curseforge.client.ModClient
import io.wury.terra.curseforge.mapper.CurseForgeMapper
import io.wury.terra.curseforge.representation.request.SearchModsRequest
import io.wury.terra.db.entity.ModDescriptionEntity
import io.wury.terra.db.entity.ModEntity
import io.wury.terra.db.repository.ModDescriptionRepository
import io.wury.terra.db.repository.ModRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty
import reactor.kotlin.core.publisher.toFlux

@Service
class ModService(
    private val modRepository: ModRepository,
    private val modDescriptionRepository: ModDescriptionRepository,
    private val modClient: ModClient,
    private val curseForgeMapper: CurseForgeMapper,
    private val modEntityToModelMapper: ModEntityToModelMapper,
    private val modModelToEntityMapper: ModModelToEntityMapper,
) {
    private fun Mono<ModEntity>.toModel(): Mono<ModModel> =
        map(modEntityToModelMapper::convert)

    private fun Flux<ModEntity>.toModel(): Flux<ModModel> =
        map(modEntityToModelMapper::convert)

    fun getModFromCurseForge(modId: Int): Mono<ModModel> {
        return modClient.getMod(modId)
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

    fun getMods(modIds: List<Int>): Flux<ModModel> =
        modIds.toFlux().flatMap { getMod(it) }

    fun getMod(modId: Int): Mono<ModModel> =
        modRepository.findByModId(modId).toModel().switchIfEmpty { getModFromCurseForge(modId) }

    fun getModBySlug(slug: String): Mono<ModModel> =
        modRepository.findBySlug(slug).toModel().switchIfEmpty { getModFromCurseForge(slug) }

    fun getModDescription(mod: ModModel): Mono<String> =
        modDescriptionRepository.findByModId(mod.modId).switchIfEmpty {
            modClient.getModDescription(mod.modId)
                .map { ModDescriptionEntity(modId = mod.modId, description = it.data) }
                .flatMap(modDescriptionRepository::save)
        }.map(ModDescriptionEntity::description)

    fun getModDescription(modId: Int): Mono<String> =
        getMod(modId).flatMap(::getModDescription)

    fun getModDescriptionBySlug(slug: String): Mono<String> =
        getModBySlug(slug).flatMap(::getModDescription)
}