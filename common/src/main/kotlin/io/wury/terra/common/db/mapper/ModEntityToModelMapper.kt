package io.wury.terra.common.db.mapper

import io.wury.terra.common.core.model.ModModel
import io.wury.terra.common.db.entity.ModEntity
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface ModEntityToModelMapper : Converter<ModEntity, ModModel> {
    override fun convert(source: ModEntity): ModModel
}