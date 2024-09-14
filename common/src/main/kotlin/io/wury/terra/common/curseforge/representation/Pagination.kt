package io.wury.terra.common.curseforge.representation

data class Pagination(
    val index: Int,
    val pageSize: Int,
    val resultCount: Int,
    val totalCount: Int,
)
