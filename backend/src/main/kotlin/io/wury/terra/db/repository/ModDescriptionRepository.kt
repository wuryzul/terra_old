package io.wury.terra.db.repository

import io.wury.terra.db.entity.ModDescriptionEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Mono

interface ModDescriptionRepository : R2dbcRepository<ModDescriptionEntity, Long> {
    @Query(
        "select * from mod_description md inner join mod m where md.mod_id = m.id and m.curseForgeID = :curseForgeID"
    )
    fun findByCurseForgeID(curseForgeID: Long): Mono<ModDescriptionEntity>

    @Query(
        "select * from mod_description md inner join mod m where md.mod_id = m.id and m.slug = :slug"
    )
    fun findBySlug(slug: String): Mono<ModDescriptionEntity>
}