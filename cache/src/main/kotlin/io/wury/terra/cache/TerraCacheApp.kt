package io.wury.terra.cache

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TerraCacheApp

fun main(vararg args: String) {
    runApplication<TerraCacheApp>(*args)
}