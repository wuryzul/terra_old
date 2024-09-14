package io.wury.terra.cache.config

import io.wury.terra.common.config.TerraCommonConfig
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(TerraCommonConfig::class)
class TerraCacheConfig