package io.wury.terra.cache.db.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("mod_description")
data class ModDescriptionEntity(
    @Id
    val id: Int? = null,
    val modId: Int,
    val description: String,
)