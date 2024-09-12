package io.wury.terra.core.mapper

import io.wury.terra.core.model.FileModel
import io.wury.terra.db.entity.FileEntity
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface FileEntityToModelMapper : Converter<FileEntity, FileModel> {
    override fun convert(source: FileEntity): FileModel
}