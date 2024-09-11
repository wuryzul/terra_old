plugins {
  id("io.wury.terra.gradle.kotlin.terra-kotlin-library")
  id("io.wury.terra.gradle.kotlin.terra-kotlin-spring")
  id("io.wury.terra.gradle.spirng.terra-spring-boot")
}

dependencies {
  implementation(platform(rootProject))

  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
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