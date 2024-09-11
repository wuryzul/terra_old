package io.wury.terra.db.repository

import io.wury.terra.db.entity.ModEntity
import org.springframework.data.r2dbc.repository.R2dbcRepository

interface ModRepository : R2dbcRepository<ModEntity, Long> {

}