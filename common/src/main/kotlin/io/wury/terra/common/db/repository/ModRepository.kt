package io.wury.terra.common.db.repository

import io.wury.terra.common.db.entity.ModEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ModRepository : CoroutineCrudRepository<ModEntity, Int> {
    suspend fun findByModId(modId: Int): ModEntity
    fun findByModId(modIds: Iterable<Int>): Flow<ModEntity>

    suspend fun existsByModId(modId: Int): Boolean

    suspend fun findBySlug(slug: String): ModEntity
    fun findBySlug(slugs: Iterable<String>): Flow<ModEntity>
}