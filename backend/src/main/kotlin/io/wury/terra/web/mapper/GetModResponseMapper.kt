package io.wury.terra.web.mapper

import io.wury.terra.core.model.ModModel
import io.wury.terra.web.representation.response.GetModResponse
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface GetModResponseMapper : Converter<ModModel, GetModResponse> {
    override fun convert(source: ModModel): GetModResponse
}