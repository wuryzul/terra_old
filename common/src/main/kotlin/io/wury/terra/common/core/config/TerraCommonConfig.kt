package io.wury.terra.common.core.config

import io.wury.terra.common.core.config.TerraClientConfig
import io.wury.terra.common.curseforge.config.CurseForgeConfig
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@ComponentScan("io.wury.terra.common")
@EnableConfigurationProperties(TerraClientConfig::class, CurseForgeConfig::class)
@EnableR2dbcRepositories("io.wury.terra.common")
class TerraCommonConfig