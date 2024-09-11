plugins {
  id("com.github.ben-manes.versions") version "0.51.0"
  id("org.gradle.kotlin.kotlin-dsl") version "5.1.1"
}

repositories {
  gradlePluginPortal()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.20")
  implementation("org.jetbrains.kotlin:kotlin-allopen:2.0.20")
  implementation("io.spring.gradle:dependency-management-plugin:1.1.6")
  implementation("org.springframework.boot:spring-boot-gradle-plugin:3.3.3")
  implementation("com.github.node-gradle:gradle-node-plugin:7.0.2")
}