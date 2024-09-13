package io.wury.terra.cache.curseforge.model.mapper

import io.wury.terra.cache.curseforge.model.file.File
import io.wury.terra.common.core.model.FileModel
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface CurseForgeFileMapper : Converter<File, FileModel> {
    override fun convert(source: File): FileModel
}