package io.wury.terra.common.db.repository

import io.wury.terra.common.db.entity.FileEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface FileRepository : CoroutineCrudRepository<FileEntity, Int> {
    suspend fun findByModIdAndFileId(modId: Int, fileId: Int): FileEntity
    suspend fun existsByModIdAndFileId(modId: Int, fileId: Int): Boolean
}