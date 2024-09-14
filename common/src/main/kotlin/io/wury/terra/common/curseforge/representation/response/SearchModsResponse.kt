package io.wury.terra.common.curseforge.representation.response

import io.wury.terra.common.curseforge.model.mod.Mod
import io.wury.terra.common.curseforge.representation.Pagination

data class SearchModsResponse(
    val data: List<Mod>,
    val pagination: Pagination,
)