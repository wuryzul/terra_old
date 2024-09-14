package io.wury.terra.cache.core.service

import io.wury.terra.common.core.service.ClientModService
import io.wury.terra.common.core.model.ModModel
import io.wury.terra.common.curseforge.service.CurseForgeModService
import io.wury.terra.common.db.entity.ModDescriptionEntity
import io.wury.terra.common.db.entity.ModEntity
import io.wury.terra.common.db.mapper.ModEntityToModelMapper
import io.wury.terra.common.db.mapper.ModModelToEntityMapper
import io.wury.terra.common.db.repository.ModDescriptionRepository
import io.wury.terra.common.db.repository.ModRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

@Service
class CacheModService(
    private val modRepository: ModRepository,
    private val clientModService: ClientModService? = null,
    private val modDescriptionRepository: ModDescriptionRepository,
    private val curseForgeModService: CurseForgeModService,
    private val modEntityToModelMapper: ModEntityToModelMapper,
    private val modModelToEntityMapper: ModModelToEntityMapper,
) {
    private suspend fun ModEntity.toModel(): ModModel =
        let(modEntityToModelMapper::convert)

    private fun Flow<ModEntity>.toModel(): Flow<ModModel> =
        map(modEntityToModelMapper::convert)

    suspend fun retrieveMod(modId: Int) {
        if (!modRepository.existsByModId(modId)) {
            createMod(clientModService?.getMod(modId) ?: curseForgeModService.getMod(modId))
        }
    }

    suspend fun getModId(slug: String): Int {
        return modRepository.findBySlug(slug)?.modId ?: curseForgeModService.getMod(slug).modId
    }

    suspend fun retrieveMod(slug: String) {
        retrieveMod(getModId(slug))
    }

    suspend fun createMod(mod: ModModel): ModModel = modRepository.save(modModelToEntityMapper.convert(mod)).toModel()

    fun getAllMods(): Flow<ModModel> = modRepository.findAll().toModel()

    fun getMods(modIds: List<Int>): Flow<ModModel> =
        flow {
            modIds.forEach {
                emit(getMod(it))
            }
        }

    suspend fun getMod(modId: Int): ModModel {
        retrieveMod(modId)
        return modRepository.findByModId(modId)!!.toModel()
    }

    suspend fun getModBySlug(slug: String): ModModel {
        retrieveMod(slug)
        return modRepository.findBySlug(slug)!!.toModel()
    }

    suspend fun getModDescription(mod: ModModel): String =
        (modDescriptionRepository.findByModId(mod.modId) ?: ModDescriptionEntity(
            modId = mod.modId,
            description = curseForgeModService.getModDescription(mod.modId)
        )).let { modDescriptionRepository.save(it) }.description

    suspend fun getModDescription(modId: Int): String =
        getModDescription(getMod(modId))

    suspend fun getModDescriptionBySlug(slug: String): String =
        getModDescription(getModBySlug(slug))
}