package io.wury.terra.web.mapper

import io.wury.terra.core.model.ModModel
import io.wury.terra.web.representation.request.CreateModRequest
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface CreateModRequestMapper : Converter<CreateModRequest, ModModel> {
    override fun convert(source: CreateModRequest): ModModel
}