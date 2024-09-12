package io.wury.terra.db.config

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.wury.terra.db.converter.ModStatusReadConverter
import io.wury.terra.db.converter.ModStatusWriteConverter
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration

//@Configuration
class TerraDBConfig : AbstractR2dbcConfiguration() {
    override fun connectionFactory(): ConnectionFactory {
        return ConnectionFactories.get("r2dbc:postgresql://localhost:5432/terra")
    }

    override fun getCustomConverters(): MutableList<Any> {
        return mutableListOf(ModStatusReadConverter(), ModStatusWriteConverter())
    }
}