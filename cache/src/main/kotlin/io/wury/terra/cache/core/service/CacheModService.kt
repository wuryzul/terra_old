package io.wury.terra.cache.core.service

import io.wury.terra.cache.curseforge.client.ModClient
import io.wury.terra.cache.curseforge.model.mapper.CurseForgeModMapper
import io.wury.terra.cache.curseforge.representation.request.SearchModsRequest
import io.wury.terra.cache.db.entity.ModDescriptionEntity
import io.wury.terra.cache.db.entity.ModEntity
import io.wury.terra.cache.db.mapper.ModEntityToModelMapper
import io.wury.terra.cache.db.mapper.ModModelToEntityMapper
import io.wury.terra.cache.db.repository.ModDescriptionRepository
import io.wury.terra.cache.db.repository.ModRepository
import io.wury.terra.common.core.model.ModModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

@Service
class CacheModService(
    private val modRepository: ModRepository,
    private val modDescriptionRepository: ModDescriptionRepository,
    private val modClient: ModClient,
    private val curseForgeModMapper: CurseForgeModMapper,
    private val modEntityToModelMapper: ModEntityToModelMapper,
    private val modModelToEntityMapper: ModModelToEntityMapper,
) {
    private suspend fun ModEntity.toModel(): ModModel =
        let(modEntityToModelMapper::convert)

    private fun Flow<ModEntity>.toModel(): Flow<ModModel> =
        map(modEntityToModelMapper::convert)

    suspend fun getModFromCurseForge(modId: Int): ModModel {
        return createMod(curseForgeModMapper.convert(modClient.getMod(modId).data))
    }

    suspend fun getModFromCurseForge(slug: String): ModModel {
        return modClient.searchMods(
            SearchModsRequest(
                gameId = 432,
                slug = slug
            )
        ).data.single().let { curseForgeModMapper.convert(it) }.let { createMod(it) }
    }

    suspend fun createMod(mod: ModModel): ModModel = modRepository.save(modModelToEntityMapper.convert(mod)).toModel()

    fun getAllMods(): Flow<ModModel> = modRepository.findAll().toModel()

    fun getMods(modIds: List<Int>): Flow<ModModel> =
        flow {
            modIds.forEach {
                emit(getMod(it))
            }
        }

    suspend fun getMod(modId: Int): ModModel =
        modRepository.findByModId(modId)?.toModel() ?: getModFromCurseForge(modId)

    suspend fun getModBySlug(slug: String): ModModel =
        modRepository.findBySlug(slug)?.toModel() ?: getModFromCurseForge(slug)

    suspend fun getModDescription(mod: ModModel): String =
        (modDescriptionRepository.findByModId(mod.modId) ?: ModDescriptionEntity(
            modId = mod.modId,
            description = modClient.getModDescription(mod.modId).data
        )).let { modDescriptionRepository.save(it) }.description

    suspend fun getModDescription(modId: Int): String =
        getModDescription(getMod(modId))

    suspend fun getModDescriptionBySlug(slug: String): String =
        getModDescription(getModBySlug(slug))
}