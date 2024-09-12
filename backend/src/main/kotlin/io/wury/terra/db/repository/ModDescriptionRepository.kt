package io.wury.terra.db.repository

import io.wury.terra.db.entity.ModDescriptionEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Mono

interface ModDescriptionRepository : R2dbcRepository<ModDescriptionEntity, Int> {
    @Query(
        "select * from mod_description md where md.mod_id = :modId"
    )
    fun findByModId(modId: Int): Mono<ModDescriptionEntity>

    @Query(
        "select * from mod_description md inner join mod m on md.mod_id = m.mod_id where m.slug = :slug"
    )
    fun findBySlug(slug: String): Mono<ModDescriptionEntity>
}