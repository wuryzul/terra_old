package io.wury.terra.db.converter

import io.wury.terra.core.model.ModStatus
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import org.springframework.stereotype.Service

@ReadingConverter
@Service
class ModStatusReadConverter : Converter<Int, ModStatus> {
    override fun convert(source: Int): ModStatus =
        ModStatus.entries.single { status -> status.value==source }
}