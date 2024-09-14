package io.wury.terra.common.curseforge.model.file

import io.wury.terra.common.curseforge.model.game.SortableGameVersion

data class File(
    val id: Int,
    val gameId: Int,
    val modId: Int,
    val isAvailable: Boolean,
    val displayName: String,
    val fileName: String,
    val releaseType: FileReleaseType,
    val fileStatus: FileStatus,
    val hashes: List<FileHash>,
    val fileDate: String,
    val fileLength: Long,
    val downloadCount: Long,
    val fileSizeOnDisk: Long? = null,
    val downloadUrl: String,
    val gameVersions: List<String>,
    val sortableGameVersions: List<SortableGameVersion>,
    val dependencies: List<FileDependency>,
    val exposeAsAlternative: Boolean? = null,
    val parentProjectFileId: Int? = null,
    val alternateFileId: Int? = null,
    val isServerPack: Boolean? = null,
    val serverPackFileId: Int? = null,
    val isEarlyAccessContent: Boolean? = null,
    val earlyAccessEndDate: String? = null,
    val fileFingerprint: Long,
    val modules: List<FileModule>,
)
