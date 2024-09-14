package io.wury.terra.common.curseforge.representation.request

data class GetModsRequest(
    val modIds: List<Int>,
    val filterPcOnly: Boolean? = null,
)