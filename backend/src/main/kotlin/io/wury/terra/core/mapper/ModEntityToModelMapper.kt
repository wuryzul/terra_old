package io.wury.terra.core.mapper

import io.wury.terra.core.model.ModModel
import io.wury.terra.db.entity.ModEntity
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface ModEntityToModelMapper : Converter<ModEntity, ModModel> {
    override fun convert(source: ModEntity): ModModel
}