package io.wury.terra.common.db.entity.mapper

import io.wury.terra.common.model.FileModel
import io.wury.terra.common.db.entity.FileEntity
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface FileEntityToModelMapper : Converter<FileEntity, FileModel> {
    override fun convert(source: FileEntity): FileModel
}