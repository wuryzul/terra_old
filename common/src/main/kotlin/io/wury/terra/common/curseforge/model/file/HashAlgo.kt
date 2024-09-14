package io.wury.terra.common.curseforge.model.file

import com.fasterxml.jackson.annotation.JsonValue

enum class HashAlgo(
    @JsonValue
    val value: Int,
) {
    Unknown(-1),
    Sha1(1),
    Md5(2),
    ;
}
