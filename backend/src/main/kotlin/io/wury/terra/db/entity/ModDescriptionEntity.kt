package io.wury.terra.db.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("mod_description")
data class ModDescriptionEntity(
    @Id
    val id: Long? = null,
    val modId: Long,
    val description: String,
)