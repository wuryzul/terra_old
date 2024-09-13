package io.wury.terra.cache.curseforge.model.file

data class FileHash(
    val value: String,
    val algo: io.wury.terra.cache.curseforge.model.file.HashAlgo,
)
