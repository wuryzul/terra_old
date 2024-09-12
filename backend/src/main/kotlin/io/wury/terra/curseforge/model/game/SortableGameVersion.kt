package io.wury.terra.curseforge.model.game

data class SortableGameVersion(
    val gameVersionName: String,
    val gameVersionPadded: String,
    val gameVersion: String,
    val gameVersionReleaseDate: String,
    val gameVersionTypeId: Int? = null,
)
