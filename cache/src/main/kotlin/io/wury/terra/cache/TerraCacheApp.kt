package io.wury.terra.cache

import io.wury.terra.common.curseforge.config.CurseForgeConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("io.wury.terra.cache")
@EnableConfigurationProperties(CurseForgeConfig::class)
class TerraCacheApp

fun main(vararg args: String) {
    runApplication<TerraCacheApp>(*args)
}