package io.wury.terra.cache.curseforge.model.mod

import io.wury.terra.cache.curseforge.model.category.Category
import io.wury.terra.cache.curseforge.model.file.File
import io.wury.terra.cache.curseforge.model.file.FileIndex

data class Mod(
    val id: Int,
    val gameId: Int,
    val name: String,
    val slug: String,
    val links: ModLinks,
    val summary: String,
    val status: ModStatus,
    val downloadCount: Long,
    val isFeatured: Boolean,
    val primaryCategoryId: Int,
    val categories: List<Category>,
    val classId: Int? = null,
    val authors: List<ModAuthor>,
    val logo: ModAsset,
    val screenshots: List<ModAsset>,
    val mainFileId: Int,
    val latestFiles: List<File>,
    val latestFilesIndexes: List<FileIndex> = emptyList(),
    val latestEarlyAccessFilesIndexes: List<FileIndex> = emptyList(),
    val dateCreated: String,
    val dateModified: String,
    val dateReleased: String,
    val allowModDistribution: Boolean? = null,
    val gamePopularityRank: Int,
    val isAvailable: Boolean,
    val thumbsUpCount: Int,
    val rating: Double? = null,
)
