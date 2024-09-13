package io.wury.terra.cache.curseforge.model.file

data class FileDependency(
    val modId: Int,
    val relationType: io.wury.terra.cache.curseforge.model.file.FileRelationType,
)
