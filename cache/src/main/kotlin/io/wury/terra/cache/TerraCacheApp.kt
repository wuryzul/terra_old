package io.wury.terra.cache

import io.wury.terra.cache.curseforge.config.CurseForgeConfig
import io.wury.terra.common.config.JacksonConfiguration
import io.wury.terra.common.config.MapperConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import

@SpringBootApplication
@ComponentScan("io.wury.terra")
@Import(MapperConfig::class, JacksonConfiguration::class)
@EnableConfigurationProperties(CurseForgeConfig::class)
class TerraCacheApp

fun main(vararg args: String) {
    runApplication<TerraCacheApp>(*args)
}