package io.wury.terra.backend

import io.wury.terra.common.config.JacksonConfiguration
import io.wury.terra.common.config.MapperConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
@Import(MapperConfig::class, JacksonConfiguration::class)
class TerraBackendApp

fun main(vararg args: String) {
    runApplication<TerraBackendApp>(*args)
}