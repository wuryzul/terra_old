package io.wury.terra.common.client.representation.mapper

import io.wury.terra.common.core.model.ModModel
import io.wury.terra.common.web.representation.response.GetModResponse
import org.mapstruct.Mapper
import org.springframework.core.convert.converter.Converter

@Mapper
interface ClientGetModResponseMapper : Converter<GetModResponse, ModModel> {
    override fun convert(source: GetModResponse): ModModel
}