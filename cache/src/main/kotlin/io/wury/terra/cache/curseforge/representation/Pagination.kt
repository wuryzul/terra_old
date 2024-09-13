package io.wury.terra.cache.curseforge.representation

data class Pagination(
    val index: Int,
    val pageSize: Int,
    val resultCount: Int,
    val totalCount: Int,
)
