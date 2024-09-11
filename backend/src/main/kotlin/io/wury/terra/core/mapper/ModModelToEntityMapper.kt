package io.wury.terra.core.mapper

import io.wury.terra.core.model.ModModel
import io.wury.terra.db.entity.ModEntity
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface ModModelToEntityMapper : Converter<ModModel, ModEntity> {
    override fun convert(source: ModModel): ModEntity
}