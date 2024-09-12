package io.wury.terra.db.repository

import io.wury.terra.db.entity.ModEntity
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Mono

interface ModRepository : R2dbcRepository<ModEntity, Long> {
    fun findByCurseForgeID(curseForgeID: Long): Mono<ModEntity>
}