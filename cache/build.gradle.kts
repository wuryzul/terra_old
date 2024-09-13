plugins {
    id("io.wury.terra.gradle.kotlin.terra-kotlin-library")
    id("io.wury.terra.gradle.kotlin.terra-kotlin-spring")
    id("io.wury.terra.gradle.spring.terra-spring-boot")
}

dependencies {
    implementation(platform(rootProject))
    implementation(project(":common"))

    implementation(libs.mapstruct)
    implementation(libs.mapstruct.spring.annotations)

    implementation(libs.mapstruct)
    implementation(libs.mapstruct.spring.annotations)

    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.spring.boot.starter.data.r2dbc)
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.spring.boot.starter.webflux)

    implementation(libs.liquibase.core)
    implementation(libs.spring.jdbc)

    developmentOnly(libs.spring.boot.devtools)

    runtimeOnly(libs.micrometer.registry.prometheus)
    runtimeOnly(libs.postgresql)
    runtimeOnly(libs.postgresql.r2dbc)

    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.spring.boot.testcontainers)
    testImplementation(libs.reactor.test)
    testImplementation(kotlin("test-junit5"))

    testImplementation(libs.testcontainers.junit.jupiter)
    testImplementation(libs.testcontainers.postgresql)
    testImplementation(libs.testcontainers.r2dbc)

    testRuntimeOnly(libs.junit.platform.launcher)
}