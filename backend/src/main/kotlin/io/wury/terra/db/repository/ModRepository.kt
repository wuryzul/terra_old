package io.wury.terra.db.repository

import io.wury.terra.db.entity.ModEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ModRepository : R2dbcRepository<ModEntity, Long> {
    fun findByCurseForgeID(curseForgeID: Long): Mono<ModEntity>
    fun findAllByCurseForgeID(curseForgeIDs: Iterable<Long>): Flux<ModEntity>
    fun findBySlug(slug: String): Mono<ModEntity>

    @Query("insert into mod_description (mod_id, description) values (:modId, :description)")
    fun insertDescription(modId: Long, description: String)

    @Query("select mod_description.description from mod_description where mod_description.mod_id = :modId")
    fun getDescription(modId: Long): Mono<String>
}