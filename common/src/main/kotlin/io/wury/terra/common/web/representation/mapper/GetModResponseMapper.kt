package io.wury.terra.common.web.representation.mapper

import io.wury.terra.common.model.ModModel
import io.wury.terra.common.web.representation.response.GetModResponse
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface GetModResponseMapper : Converter<ModModel, GetModResponse> {
    override fun convert(source: ModModel): GetModResponse
}