package io.wury.terra.common.db.repository

import io.wury.terra.common.db.entity.ModDescriptionEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ModDescriptionRepository : CoroutineCrudRepository<ModDescriptionEntity, Int> {
    suspend fun findByModId(modId: Int): ModDescriptionEntity

    @Query("select * from mod_description md inner join mod m on md.mod_id = m.mod_id where m.slug = :slug")
    suspend fun findBySlug(slug: String): ModDescriptionEntity
}