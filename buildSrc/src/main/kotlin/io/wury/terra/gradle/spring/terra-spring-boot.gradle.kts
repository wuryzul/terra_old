package io.wury.terra.gradle.spring

import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("io.wury.terra.gradle.spring.terra-spring")
    id("org.springframework.boot")
}

tasks.withType<BootRun> {
    workingDir = file("run")

    systemProperty("spring.profiles.active", "local,dev")

    doFirst {
        workingDir.mkdirs()
    }
}