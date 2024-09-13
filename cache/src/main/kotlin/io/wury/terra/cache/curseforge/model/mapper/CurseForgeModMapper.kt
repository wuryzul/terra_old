package io.wury.terra.cache.curseforge.model.mapper

import io.wury.terra.cache.curseforge.model.mod.Mod
import io.wury.terra.common.core.model.ModModel
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface CurseForgeModMapper : Converter<Mod, ModModel> {
    override fun convert(source: Mod): ModModel
}