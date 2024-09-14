package io.wury.terra.common.config

import io.wury.terra.common.client.config.TerraClientConfig
import io.wury.terra.common.curseforge.config.CurseForgeConfig
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan("io.wury.terra.common")
@EnableConfigurationProperties(TerraClientConfig::class, CurseForgeConfig::class)
class TerraCommonConfig