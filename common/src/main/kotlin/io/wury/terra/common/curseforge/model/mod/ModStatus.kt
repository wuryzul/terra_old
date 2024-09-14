package io.wury.terra.common.curseforge.model.mod

import com.fasterxml.jackson.annotation.JsonValue

enum class ModStatus(
    @JsonValue
    val value: Int,
) {
    Unknown(-1),
    New(1),
    ChangesRequired(2),
    UnderSoftReview(3),
    Approved(4),
    Rejected(5),
    ChangesMade(6),
    Inactive(7),
    Abandoned(8),
    Deleted(9),
    UnderReview(10),
    ;
}