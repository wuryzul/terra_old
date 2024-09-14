package io.wury.terra.backend.config

import io.wury.terra.common.core.config.TerraCommonConfig
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(TerraCommonConfig::class)
class TerraBackendConfig