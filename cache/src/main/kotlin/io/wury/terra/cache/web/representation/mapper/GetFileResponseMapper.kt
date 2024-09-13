package io.wury.terra.cache.web.representation.mapper

import io.wury.terra.common.core.model.FileModel
import io.wury.terra.cache.web.representation.response.GetFileResponse
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface GetFileResponseMapper : Converter<FileModel, GetFileResponse> {
    override fun convert(source: FileModel): GetFileResponse
}