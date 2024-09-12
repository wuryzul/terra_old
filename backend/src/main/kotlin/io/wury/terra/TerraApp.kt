package io.wury.terra

import io.wury.terra.config.MapperConfig
import io.wury.terra.core.config.JacksonConfiguration
import io.wury.terra.curseforge.config.CurseForgeConfig
import io.wury.terra.curseforge.config.WebClientConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
@Import(MapperConfig::class, WebClientConfig::class, JacksonConfiguration::class)
@EnableConfigurationProperties(CurseForgeConfig::class)
class TerraApp

fun main(vararg args: String) {
    runApplication<TerraApp>(*args)
}