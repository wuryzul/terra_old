package io.wury.terra.db.repository

import io.wury.terra.db.entity.FileEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface FileRepository : CoroutineCrudRepository<FileEntity, Int> {
    @Query("select * from file f where f.mod_id = :modId and f.file_id = :fileId")
    suspend fun findById(modId: Int, fileId: Int): FileEntity?
}