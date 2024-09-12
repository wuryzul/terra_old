package io.wury.terra.db.repository

import io.wury.terra.db.entity.ModEntity
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ModRepository : R2dbcRepository<ModEntity, Int> {
    fun findByModId(modId: Int): Mono<ModEntity>
    fun findByModId(modIds: Iterable<Int>): Flux<ModEntity>
    fun findBySlug(slug: String): Mono<ModEntity>
    fun findBySlug(slugs: Iterable<String>): Mono<ModEntity>
}