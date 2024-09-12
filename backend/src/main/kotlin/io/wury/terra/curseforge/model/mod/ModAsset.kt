package io.wury.terra.curseforge.model.mod

data class ModAsset(
    val id: Int,
    val modId: Int,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val url: String,
)
