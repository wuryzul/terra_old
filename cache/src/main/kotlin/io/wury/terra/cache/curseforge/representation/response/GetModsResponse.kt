package io.wury.terra.cache.curseforge.representation.response

import io.wury.terra.cache.curseforge.model.mod.Mod

data class GetModsResponse(
    val data: List<Mod>
)
