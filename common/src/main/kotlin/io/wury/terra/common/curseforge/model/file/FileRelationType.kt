package io.wury.terra.common.curseforge.model.file

import com.fasterxml.jackson.annotation.JsonValue

enum class FileRelationType(
    @JsonValue
    val value: Int,
) {
    Unknown(-1),
    EmbeddedLibrary(1),
    OptionalDependency(2),
    RequiredDependency(3),
    Tool(4),
    Incompatible(5),
    Include(6),
    ;
}
