plugins {
  id("com.github.ben-manes.versions") version "0.51.0"
  id("io.wury.terra.gradle.terra-root")
}

javaPlatform {
  allowDependencies()
}

dependencies {
  api(platform(libs.kotlinx.coroutines.bom))
  api(platform(libs.jackson.bom))
  api(platform(libs.spring.boot.dependencies))
  api(platform(libs.spring.shell.dependencies))
}