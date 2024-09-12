package io.wury.terra.curseforge.representation.request

data class GetFeaturedModsRequest(
    val gameId: Int,
    val excludedModIds: List<Int>,
    val gameVersionTypeId: Int? = null,
)
