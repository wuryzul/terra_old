package io.wury.terra.curseforge.mapper

import io.wury.terra.core.model.ModModel
import io.wury.terra.curseforge.model.mod.Mod
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface CurseForgeMapper {
    @Mapping(source = "id", target = "curseForgeID")
    @Mapping(target = "id", ignore = true)
    fun mapMod(mod: Mod): ModModel
}