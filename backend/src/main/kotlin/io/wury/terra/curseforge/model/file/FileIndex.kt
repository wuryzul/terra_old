package io.wury.terra.curseforge.model.file

import com.fasterxml.jackson.annotation.JsonProperty
import io.wury.terra.curseforge.model.game.ModLoaderType

data class FileIndex(
    val gameVersion: String,
    val fileId: Int,
    @JsonProperty("filename")
    val fileName: String,
    val releaseType: FileReleaseType,
    val gameVersionTypeId: Int? = null,
    val modLoader: ModLoaderType? = null,
)
