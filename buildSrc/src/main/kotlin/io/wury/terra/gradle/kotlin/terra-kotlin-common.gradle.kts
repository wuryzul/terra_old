package io.wury.terra.gradle.kotlin

plugins {
    id("io.wury.terra.gradle.java.terra-java-common")
    kotlin("jvm")
}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        freeCompilerArgs.addAll(
            "-Xjsr305=strict",
        )
    }
}