package io.wury.terra.curseforge.model.game

import com.fasterxml.jackson.annotation.JsonValue

enum class ModLoaderType(
    @JsonValue
    val value: Int,
) {
    Unknown(-1),
    Any(0),
    Forge(1),
    Cauldron(2),
    LiteLoader(3),
    Fabric(4),
    Quilt(5),
    NeoForge(6),
    ;
}
