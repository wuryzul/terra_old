package io.wury.terra.backend

import io.wury.terra.backend.client.config.TerraClientConfig
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
@EnableConfigurationProperties(TerraClientConfig::class)
class TerraBackendApp

fun main(vararg args: String) {
    runApplication<TerraBackendApp>(*args)
}