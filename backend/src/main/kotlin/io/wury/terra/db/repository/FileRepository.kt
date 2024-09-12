package io.wury.terra.db.repository

import io.wury.terra.db.entity.FileEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Mono

interface FileRepository : R2dbcRepository<FileEntity, Int> {
    @Query("select * from file f where f.mod_id = :modId and f.file_id = :fileId")
    fun findById(modId: Int, fileId: Int): Mono<FileEntity>
}