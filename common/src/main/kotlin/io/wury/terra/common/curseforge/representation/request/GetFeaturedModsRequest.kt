package io.wury.terra.common.curseforge.representation.request

data class GetFeaturedModsRequest(
    val gameId: Int = 432,
    val excludedModIds: List<Int> = emptyList(),
    val gameVersionTypeId: Int? = null,
)
