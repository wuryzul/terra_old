package io.wury.terra.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TerraBackendApp

fun main(vararg args: String) {
    runApplication<TerraBackendApp>(*args)
}