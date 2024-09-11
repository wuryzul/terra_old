package io.wury.terra.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TerraApp

fun main(vararg args: String) {
  runApplication<TerraApp>(*args)
}