package io.wury.terra.cache.core.service

import io.wury.terra.common.core.service.ClientFileService
import io.wury.terra.common.core.model.FileModel
import io.wury.terra.common.curseforge.service.CurseForgeFileService
import io.wury.terra.common.db.entity.FileEntity
import io.wury.terra.common.db.mapper.FileEntityToModelMapper
import io.wury.terra.common.db.mapper.FileModelToEntityMapper
import io.wury.terra.common.db.repository.FileRepository
import org.springframework.stereotype.Service

@Service
class CacheFileService(
    private val fileRepository: FileRepository,
    private val clientFileService: ClientFileService? = null,
    private val curseForgeFileService: CurseForgeFileService,
    private val fileEntityToModelMapper: FileEntityToModelMapper,
    private val fileModelToEntityMapper: FileModelToEntityMapper,
    private val cacheModService: CacheModService,
) {
    suspend fun retrieveFile(modId: Int, fileId: Int) {
        if (!fileRepository.existsByModIdAndFileId(modId, fileId)) {
            createFile(clientFileService?.getFile(modId, fileId) ?: curseForgeFileService.getFile(modId, fileId))
        }
    }

    fun FileEntity.toModel(): FileModel =
        fileEntityToModelMapper.convert(this)

    suspend fun createFile(file: FileModel): FileModel {
        return cacheModService.getMod(file.modId).let {
            fileRepository.save(fileModelToEntityMapper.convert(file)).toModel()
        }
    }

    suspend fun getFile(modId: Int, fileId: Int): FileModel {
        retrieveFile(modId, fileId)
        return fileRepository.findByModIdAndFileId(modId, fileId)!!.toModel()
    }
}