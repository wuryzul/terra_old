plugins {
  id("com.github.ben-manes.versions") version "0.51.0"
  id("io.wury.terra.gradle.terra-root")
}

javaPlatform {
  allowDependencies()
}

dependencies {
  api(platform(libs.jersey.bom))
  api(platform(libs.spring.modulith.bom))
}