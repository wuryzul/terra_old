package io.wury.terra.curseforge.model.file

import com.fasterxml.jackson.annotation.JsonValue

enum class FileReleaseType(
    @JsonValue
    val value: Int,
) {
    Unknown(-1),
    Release(1),
    Beta(2),
    Alpha(3),
    ;
}
