package io.wury.terra.common.db.entity.mapper

import io.wury.terra.common.model.FileModel
import io.wury.terra.common.db.entity.FileEntity
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface FileModelToEntityMapper : Converter<FileModel, FileEntity> {
    override fun convert(source: FileModel): FileEntity
}