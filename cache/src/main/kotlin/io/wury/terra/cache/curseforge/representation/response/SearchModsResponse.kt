package io.wury.terra.cache.curseforge.representation.response

import io.wury.terra.cache.curseforge.model.mod.Mod
import io.wury.terra.cache.curseforge.representation.Pagination

data class SearchModsResponse(
    val data: List<Mod>,
    val pagination: Pagination,
)