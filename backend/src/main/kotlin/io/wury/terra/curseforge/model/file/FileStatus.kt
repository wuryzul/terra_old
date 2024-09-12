package io.wury.terra.curseforge.model.file

import com.fasterxml.jackson.annotation.JsonValue

enum class FileStatus(
    @JsonValue
    val value: Int,
) {
    Unknown(-1),
    Processing(1),
    ChangesRequired(2),
    UnderReview(3),
    Approved(4),
    Rejected(5),
    MalwareDetected(6),
    Deleted(7),
    Archived(8),
    Testing(9),
    Released(10),
    ReadyForReview(11),
    Deprecated(12),
    Baking(13),
    AwaitingPublishing(14),
    FailedPublishing(15),
    ;
}
