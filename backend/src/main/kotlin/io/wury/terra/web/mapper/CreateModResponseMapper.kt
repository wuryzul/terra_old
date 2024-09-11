package io.wury.terra.web.mapper

import io.wury.terra.core.model.ModModel
import io.wury.terra.web.representation.response.CreateModResponse
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface CreateModResponseMapper : Converter<ModModel, CreateModResponse> {
    override fun convert(source: ModModel): CreateModResponse
}