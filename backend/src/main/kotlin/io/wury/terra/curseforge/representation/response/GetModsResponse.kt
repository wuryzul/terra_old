package io.wury.terra.curseforge.representation.response

import io.wury.terra.curseforge.model.mod.Mod

data class GetModsResponse(
    val data: List<Mod>
)
