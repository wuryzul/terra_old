package io.wury.terra.common.curseforge.model.file

data class FileDependency(
    val modId: Int,
    val relationType: FileRelationType,
)
