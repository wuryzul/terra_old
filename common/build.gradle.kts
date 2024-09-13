plugins {
    id("io.wury.terra.gradle.kotlin.terra-kotlin-library")
    id("io.wury.terra.gradle.kotlin.terra-kotlin-spring")
}

dependencies {
    implementation(platform(rootProject))

    api(libs.jackson.module.kotlin)
    api(libs.reactor.kotlin.extensions)
    api(libs.kotlinx.coroutines.reactor)

    implementation(libs.mapstruct)
    implementation(libs.mapstruct.spring.annotations)

    implementation(libs.spring.boot.starter.webflux)
}