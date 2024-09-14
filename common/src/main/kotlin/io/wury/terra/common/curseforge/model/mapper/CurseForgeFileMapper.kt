package io.wury.terra.common.curseforge.model.mapper

import io.wury.terra.common.curseforge.model.file.File
import io.wury.terra.common.model.FileModel
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.core.convert.converter.Converter

@Mapper
interface CurseForgeFileMapper : Converter<File, FileModel> {
    @Mapping(source = "id", target = "fileId")
    @Mapping(target = "id", ignore = true)
    override fun convert(source: File): FileModel
}