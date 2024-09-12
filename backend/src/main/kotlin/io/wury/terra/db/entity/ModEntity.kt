package io.wury.terra.db.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("mod")
data class ModEntity(
    @Id
    @Column("ID")
    val id: Long? = null,
    @Column("CURSE_FORGE_ID")
    val curseForgeID: Long,
)