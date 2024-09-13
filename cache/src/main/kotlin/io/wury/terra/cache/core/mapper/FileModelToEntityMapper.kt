package io.wury.terra.cache.core.mapper

import io.wury.terra.common.core.model.FileModel
import io.wury.terra.cache.db.entity.FileEntity
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface FileModelToEntityMapper : Converter<FileModel, FileEntity> {
    override fun convert(source: FileModel): FileEntity
}