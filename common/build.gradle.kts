plugins {
    id("io.wury.terra.gradle.kotlin.terra-kotlin-kapt")
    id("io.wury.terra.gradle.kotlin.terra-kotlin-library")
    id("io.wury.terra.gradle.kotlin.terra-kotlin-spring")
}

dependencies {
    implementation(platform(rootProject))

    kapt(libs.spring.boot.configuration.processor)
    kapt(libs.spring.cloud.starter.gateway)
    kapt(libs.mapstruct.processor)
    kapt(libs.mapstruct.spring.extensions)

    api(libs.jackson.module.kotlin)
    api(libs.reactor.kotlin.extensions)
    api(libs.kotlinx.coroutines.reactor)

    implementation(libs.mapstruct)
    implementation(libs.mapstruct.spring.annotations)

    implementation(libs.spring.boot.starter.webflux)
    implementation(libs.spring.boot.starter.data.r2dbc)
    implementation(libs.spring.cloud.starter.gateway)
}

kapt {
    arguments {
        arg("mapstruct.defaultComponentModel", "spring")
    }
}