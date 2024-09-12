package io.wury.terra.curseforge.representation.response

import io.wury.terra.curseforge.model.mod.Mod

data class FeaturedModsResponse(
    val featured: List<Mod>,
    val popular: List<Mod>,
    val recentlyUpdated: List<Mod>,
)
