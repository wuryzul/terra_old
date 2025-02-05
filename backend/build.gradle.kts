import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("io.wury.terra.gradle.kotlin.terra-kotlin-kapt")
    id("io.wury.terra.gradle.kotlin.terra-kotlin-library")
    id("io.wury.terra.gradle.kotlin.terra-kotlin-spring")
    id("io.wury.terra.gradle.spring.terra-spring-boot")
}

dependencies {
    implementation(platform(rootProject))
    implementation(project(":common"))

    kapt(libs.spring.boot.configuration.processor)
    kapt(libs.mapstruct.processor)

    implementation(libs.mapstruct)
    implementation(libs.mapstruct.spring.annotations)

    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.spring.boot.starter.data.r2dbc)
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.spring.boot.starter.webflux)
    implementation(libs.spring.cloud.starter.gateway)
    implementation(libs.spring.shell.starter)

    implementation(libs.liquibase.core)
    runtimeOnly(libs.h2)
    runtimeOnly(libs.r2dbc.h2)

    developmentOnly(libs.spring.boot.devtools)

    runtimeOnly(libs.micrometer.registry.prometheus)

    testImplementation(libs.spring.shell.starter.test)
    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.spring.boot.testcontainers)
    testImplementation(libs.reactor.test)
    testImplementation(kotlin("test-junit5"))

    testImplementation(libs.testcontainers.junit.jupiter)
    testImplementation(libs.testcontainers.r2dbc)

    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.named("processResources") {
    dependsOn(":frontend:nodeSetup", ":frontend:pnpmSetup", ":frontend:pnpmBuild")
}

tasks.named<BootRun>("bootRun") {
    classpath(project(":frontend").file("dist"))
}

tasks.named<Jar>("bootJar") {
    from(project(":frontend").file("dist/resources")) {
        into("static")
    }
}

kapt {
    arguments {
        arg("mapstruct.defaultComponentModel", "spring")
    }
}