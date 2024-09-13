package io.wury.terra.cache.curseforge.representation.request

data class GetModsRequest(
    val modIds: List<Int>,
    val filterPcOnly: Boolean? = null,
)