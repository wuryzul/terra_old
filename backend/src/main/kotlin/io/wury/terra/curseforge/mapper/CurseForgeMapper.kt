package io.wury.terra.curseforge.mapper

import io.wury.terra.core.model.FileModel
import io.wury.terra.core.model.ModModel
import io.wury.terra.curseforge.model.file.File
import io.wury.terra.curseforge.model.mod.Mod
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface CurseForgeMapper {
    @Mapping(source = "id", target = "modId")
    @Mapping(target = "id", ignore = true)
    fun mapMod(mod: Mod): ModModel

    @Mapping(source = "id", target = "fileId")
    @Mapping(target = "id", ignore = true)
    fun mapFile(file: File): FileModel
}