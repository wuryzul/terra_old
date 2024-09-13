package io.wury.terra.core.service

import io.wury.terra.core.mapper.ModEntityToModelMapper
import io.wury.terra.core.mapper.ModModelToEntityMapper
import io.wury.terra.core.model.ModModel
import io.wury.terra.curseforge.client.ModClient
import io.wury.terra.curseforge.mapper.CurseForgeMapper
import io.wury.terra.curseforge.representation.request.SearchModsRequest
import io.wury.terra.curseforge.representation.response.StringResponse
import io.wury.terra.db.entity.ModDescriptionEntity
import io.wury.terra.db.entity.ModEntity
import io.wury.terra.db.repository.ModDescriptionRepository
import io.wury.terra.db.repository.ModRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

@Service
class ModService(
    private val modRepository: ModRepository,
    private val modDescriptionRepository: ModDescriptionRepository,
    private val modClient: ModClient,
    private val curseForgeMapper: CurseForgeMapper,
    private val modEntityToModelMapper: ModEntityToModelMapper,
    private val modModelToEntityMapper: ModModelToEntityMapper,
) {
    private suspend fun ModEntity.toModel(): ModModel =
        let(modEntityToModelMapper::convert)

    private fun Flow<ModEntity>.toModel(): Flow<ModModel> =
        map(modEntityToModelMapper::convert)

    suspend fun getModFromCurseForge(modId: Int): ModModel? {
        return modClient.getMod(modId)?.data?.let(curseForgeMapper::mapMod)?.let { createMod(it) }
    }

    suspend fun getModFromCurseForge(slug: String): ModModel? {
        return modClient.searchMods(SearchModsRequest(gameId = 432, slug = slug))?.data?.singleOrNull()?.let { curseForgeMapper.mapMod(it) }
            ?.let { createMod(it) }
    }

    suspend fun createMod(mod: ModModel): ModModel = modRepository.save(modModelToEntityMapper.convert(mod)).toModel()

    fun getAllMods(): Flow<ModModel> = modRepository.findAll().toModel()

    fun getMods(modIds: List<Int>): Flow<ModModel> =
        flow<ModModel> {
            modIds.forEach {
                getMod(it)?.let { emit(it) }
            }
        }

    suspend fun getMod(modId: Int): ModModel? =
        modRepository.findByModId(modId)?.toModel() ?: getModFromCurseForge(modId)

    suspend fun getModBySlug(slug: String): ModModel? =
        modRepository.findBySlug(slug)?.toModel() ?: getModFromCurseForge(slug)

    suspend fun getModDescription(mod: ModModel): String? = (modDescriptionRepository.findByModId(mod.modId) ?: modClient.getModDescription(mod.modId)
        ?.let<StringResponse, ModDescriptionEntity> {
            ModDescriptionEntity(
                modId = mod.modId,
                description = it.data
            )
        })?.let<ModDescriptionEntity, ModDescriptionEntity> { modDescriptionRepository.save(it) }?.description

    suspend fun getModDescription(modId: Int): String? =
        getMod(modId)?.let { getModDescription(it) }

    suspend fun getModDescriptionBySlug(slug: String): String? =
        getModBySlug(slug)?.let { getModDescription(it) }
}