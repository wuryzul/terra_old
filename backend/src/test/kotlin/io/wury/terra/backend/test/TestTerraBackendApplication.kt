package io.wury.terra.backend.test

import io.wury.terra.backend.TerraBackendApp
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(vararg args: String) {
    fromApplication<TerraBackendApp>().with(TestContainersConfiguration::class).run(*args)
}