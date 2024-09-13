package io.wury.terra.cache.core.service

import io.wury.terra.cache.core.mapper.FileEntityToModelMapper
import io.wury.terra.cache.core.mapper.FileModelToEntityMapper
import io.wury.terra.common.core.model.FileModel
import io.wury.terra.cache.curseforge.client.FileClient
import io.wury.terra.cache.curseforge.model.mapper.CurseForgeFileMapper
import io.wury.terra.cache.db.entity.FileEntity
import io.wury.terra.cache.db.repository.FileRepository
import org.springframework.stereotype.Service

@Service
class FileService(
    private val fileRepository: FileRepository,
    private val fileClient: FileClient,
    private val curseForgeFileMapper: CurseForgeFileMapper,
    private val fileEntityToModelMapper: FileEntityToModelMapper,
    private val fileModelToEntityMapper: FileModelToEntityMapper,
    private val modService: ModService,
) {
    suspend fun getFileFromCurseForge(modId: Int, fileId: Int): FileModel? {
        return fileClient.getFile(modId, fileId)
            ?.let { curseForgeFileMapper.convert(it.data) }
            ?.let { createFile(it) }
    }

    fun FileEntity.toModel(): FileModel =
        fileEntityToModelMapper.convert(this)

    suspend fun createFile(file: FileModel): FileModel {
        return modService.getMod(file.modId).let {
            fileRepository.save(fileModelToEntityMapper.convert(file)).toModel()
        }
    }

    suspend fun getFile(modId: Int, fileId: Int): FileModel? {
        return fileRepository.findById(modId, fileId)?.toModel() ?: getFileFromCurseForge(modId, fileId)
    }
}