package io.wury.terra.curseforge.representation.response

import io.wury.terra.curseforge.model.mod.Mod
import io.wury.terra.curseforge.representation.Pagination

data class SearchModsResponse(
    val data: List<Mod>,
    val pagination: Pagination,
)