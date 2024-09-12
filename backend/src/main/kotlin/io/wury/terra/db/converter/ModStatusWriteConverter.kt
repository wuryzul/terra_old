package io.wury.terra.db.converter

import io.wury.terra.core.model.ModStatus
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter
import org.springframework.stereotype.Service

@WritingConverter
@Service
class ModStatusWriteConverter : Converter<ModStatus, Int> {
    override fun convert(source: ModStatus): Int =
        source.value
}