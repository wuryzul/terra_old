package io.wury.terra.common.web.representation.response

import io.wury.terra.common.model.ModStatus

data class GetModResponse(
    val id: Int,
    val modId: Int,
    val name: String,
    val slug: String,
    val summary: String,
    val status: ModStatus,
    val downloadCount: Long,
    val featured: Boolean,
    val primaryCategoryId: Int,
    val classId: Int? = null,
    val mainFileId: Int,
    val dateCreated: String,
    val dateModified: String,
    val dateReleased: String,
    val allowModDistribution: Boolean? = null,
    val gamePopularityRank: Int,
    val available: Boolean,
    val thumbsUpCount: Int,
    val rating: Double? = null,
)
