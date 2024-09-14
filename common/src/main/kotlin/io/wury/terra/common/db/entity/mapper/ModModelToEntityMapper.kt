package io.wury.terra.common.db.entity.mapper

import io.wury.terra.common.model.ModModel
import io.wury.terra.common.db.entity.ModEntity
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface ModModelToEntityMapper : Converter<ModModel, ModEntity> {
    override fun convert(source: ModModel): ModEntity
}