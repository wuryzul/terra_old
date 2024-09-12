package io.wury.terra.core.service

import io.wury.terra.core.mapper.FileEntityToModelMapper
import io.wury.terra.core.mapper.FileModelToEntityMapper
import io.wury.terra.core.model.FileModel
import io.wury.terra.curseforge.client.FileClient
import io.wury.terra.curseforge.mapper.CurseForgeMapper
import io.wury.terra.db.entity.FileEntity
import io.wury.terra.db.repository.FileRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@Service
class FileService(
    private val fileRepository: FileRepository,
    private val fileClient: FileClient,
    private val curseForgeMapper: CurseForgeMapper,
    private val fileEntityToModelMapper: FileEntityToModelMapper,
    private val fileModelToEntityMapper: FileModelToEntityMapper,
    private val modService: ModService,
) {
    fun getFileFromCurseForge(modId: Int, fileId: Int): Mono<FileModel> {
        return fileClient.getFile(modId, fileId)
            .map { curseForgeMapper.mapFile(it.data) }
            .flatMap { createFile(it) }
    }

    fun Mono<FileEntity>.toModel(): Mono<FileModel> =
        map(fileEntityToModelMapper::convert)

    fun createFile(file: FileModel): Mono<FileModel> {
        return modService.getMod(file.modId).flatMap {
            fileRepository.save(fileModelToEntityMapper.convert(file)).toModel()
        }
    }

    fun getFile(modId: Int, fileId: Int): Mono<FileModel> {
        return fileRepository.findById(modId, fileId).toModel().switchIfEmpty { getFileFromCurseForge(modId, fileId) }
    }
}