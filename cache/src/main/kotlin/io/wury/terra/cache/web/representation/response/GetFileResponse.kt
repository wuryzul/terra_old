package io.wury.terra.cache.web.representation.response

import io.wury.terra.common.core.model.FileReleaseType
import io.wury.terra.common.core.model.FileStatus

data class GetFileResponse(
    val modId: Int,
    val fileId: Int,
    val available: Boolean,
    val displayName: String,
    val fileName: String,
    val releaseType: FileReleaseType,
    val fileStatus: FileStatus,
    val fileDate: String,
    val fileLength: Long,
    val downloadCount: Long,
    val fileSizeOnDisk: Long? = null,
    val downloadUrl: String,
    val exposeAsAlternative: Boolean? = null,
    val parentProjectFileId: Int? = null,
    val alternateFileId: Int? = null,
    val serverPack: Boolean? = null,
    val serverPackFileId: Int? = null,
    val earlyAccessContent: Boolean? = null,
    val earlyAccessEndDate: String? = null,
    val fileFingerprint: Long,
)