package io.wury.terra.test

import io.wury.terra.TerraApp
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(vararg args: String) {
    fromApplication<TerraApp>().with(TestContainersConfiguration::class).run(*args)
}