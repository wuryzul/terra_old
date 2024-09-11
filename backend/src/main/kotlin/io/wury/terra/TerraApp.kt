package io.wury.terra

import io.wury.terra.config.MapperConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
@Import(MapperConfig::class)
class TerraApp

fun main(vararg args: String) {
  runApplication<TerraApp>(*args)
}