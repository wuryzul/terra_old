package io.wury.terra.common.client.representation.mapper

import io.wury.terra.common.core.model.FileModel
import io.wury.terra.common.web.representation.response.GetFileResponse
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface ClientGetFileResponseMapper : Converter<GetFileResponse, FileModel> {
    override fun convert(source: GetFileResponse): FileModel
}