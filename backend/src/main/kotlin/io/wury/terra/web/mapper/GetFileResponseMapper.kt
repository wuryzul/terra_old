package io.wury.terra.web.mapper

import io.wury.terra.core.model.FileModel
import io.wury.terra.web.representation.response.GetFileResponse
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface GetFileResponseMapper : Converter<FileModel, GetFileResponse> {
    override fun convert(source: FileModel): GetFileResponse
}