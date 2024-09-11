package io.wury.terra.db.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("mod")
data class ModEntity(
    @Id
    val id: Long
)