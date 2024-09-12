package io.wury.terra.curseforge.representation.request

import com.fasterxml.jackson.annotation.JsonValue
import io.wury.terra.curseforge.model.game.ModLoaderType

enum class ModsSearchSortField(
    @JsonValue
    val value: Int,
) {
    Unknown(-1),
    Featured(1),
    Popularity(2),
    LastUpdated(3),
    Name(4),
    Author(5),
    TotalDownloads(6),
    Category(7),
    GameVersion(8),
    EarlyAccess(9),
    FeaturedReleased(10),
    ReleasedDate(11),
    Rating(12),
    ;
}

enum class SortOrder(
    @JsonValue
    val value: String,
) {
    Ascending("asc"),
    Descending("desc"),
}

data class SearchModsRequest(
    val gameId: Int = 432,
    val classId: Int? = null,
    val categoryId: Int? = null,
    val categoryIds: String? = null,
    val gameVersion: String? = null,
    val gameVersions: String? = null,
    val searchFilter: String? = null,
    val sortField: ModsSearchSortField? = null,
    val sortOrder: SortOrder? = null,
    val modLoaderType: ModLoaderType? = null,
    val modLoaderTypes: String? = null,
    val gameVersionTypeId: Int? = null,
    val authorId: Int? = null,
    val primaryAuthorId: Int? = null,
    val slug: String? = null,
    val index: Int? = null,
    val pageSize: Int? = null,
)