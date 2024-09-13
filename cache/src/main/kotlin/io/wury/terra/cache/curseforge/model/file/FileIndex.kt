package io.wury.terra.cache.curseforge.model.file

import com.fasterxml.jackson.annotation.JsonProperty
import io.wury.terra.cache.curseforge.model.game.ModLoaderType

data class FileIndex(
    val gameVersion: String,
    val fileId: Int,
    @JsonProperty("filename")
    val fileName: String,
    val releaseType: io.wury.terra.cache.curseforge.model.file.FileReleaseType,
    val gameVersionTypeId: Int? = null,
    val modLoader: io.wury.terra.cache.curseforge.model.game.ModLoaderType? = null,
)
