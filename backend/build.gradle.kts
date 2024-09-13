import org.springframework.boot.gradle.tasks.run.BootRun

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

    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.spring.boot.starter.data.r2dbc)
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.spring.boot.starter.webflux)

    implementation(libs.liquibase.core)
    implementation(libs.spring.jdbc)

    developmentOnly(libs.spring.boot.devtools)
    developmentOnly(libs.spring.boot.docker.compose)

    runtimeOnly(libs.micrometer.registry.prometheus)

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