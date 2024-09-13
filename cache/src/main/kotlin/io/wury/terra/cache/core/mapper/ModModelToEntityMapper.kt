package io.wury.terra.cache.core.mapper

import io.wury.terra.common.core.model.ModModel
import io.wury.terra.cache.db.entity.ModEntity
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface ModModelToEntityMapper : Converter<ModModel, ModEntity> {
    override fun convert(source: ModModel): ModEntity
}