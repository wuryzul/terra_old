package io.wury.terra.common.curseforge.model.category

data class Category(
    val id: Int,
    val gameId: Int,
    val name: String,
    val slug: String,
    val url: String,
    val iconUrl: String,
    val dateModified: String,
    val isClass: Boolean? = null,
    val classId: Int? = null,
    val parentCategoryId: Int? = null,
    val displayIndex: Int? = null,
)
