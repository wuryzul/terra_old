package io.wury.terra

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class TerraApp

fun main(vararg args: String) {
  runApplication<TerraApp>(*args)
}