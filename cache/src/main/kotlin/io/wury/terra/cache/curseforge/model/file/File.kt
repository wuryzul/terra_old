package io.wury.terra.cache.curseforge.model.file

import io.wury.terra.cache.curseforge.model.game.SortableGameVersion

data class File(
    val id: Int,
    val gameId: Int,
    val modId: Int,
    val isAvailable: Boolean,
    val displayName: String,
    val fileName: String,
    val releaseType: io.wury.terra.cache.curseforge.model.file.FileReleaseType,
    val fileStatus: io.wury.terra.cache.curseforge.model.file.FileStatus,
    val hashes: List<io.wury.terra.cache.curseforge.model.file.FileHash>,
    val fileDate: String,
    val fileLength: Long,
    val downloadCount: Long,
    val fileSizeOnDisk: Long? = null,
    val downloadUrl: String,
    val gameVersions: List<String>,
    val sortableGameVersions: List<io.wury.terra.cache.curseforge.model.game.SortableGameVersion>,
    val dependencies: List<io.wury.terra.cache.curseforge.model.file.FileDependency>,
    val exposeAsAlternative: Boolean? = null,
    val parentProjectFileId: Int? = null,
    val alternateFileId: Int? = null,
    val isServerPack: Boolean? = null,
    val serverPackFileId: Int? = null,
    val isEarlyAccessContent: Boolean? = null,
    val earlyAccessEndDate: String? = null,
    val fileFingerprint: Long,
    val modules: List<io.wury.terra.cache.curseforge.model.file.FileModule>,
)
