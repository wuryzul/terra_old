package io.wury.terra.common.curseforge.representation.response

import io.wury.terra.common.curseforge.model.mod.Mod

data class GetModsResponse(
    val data: List<Mod>
)
