package io.wury.terra.cache.curseforge.model.mapper

import io.wury.terra.cache.curseforge.model.mod.Mod
import io.wury.terra.common.core.model.ModModel
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.core.convert.converter.Converter

@Mapper
interface CurseForgeModMapper : Converter<Mod, ModModel> {
    @Mapping(source = "id", target = "modId")
    @Mapping(target = "id", ignore = true)
    override fun convert(source: Mod): ModModel
}