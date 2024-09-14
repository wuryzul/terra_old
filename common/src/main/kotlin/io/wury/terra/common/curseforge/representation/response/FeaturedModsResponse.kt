package io.wury.terra.common.curseforge.representation.response

import io.wury.terra.common.curseforge.model.mod.Mod

data class FeaturedModsResponse(
    val featured: List<Mod>,
    val popular: List<Mod>,
    val recentlyUpdated: List<Mod>,
)
