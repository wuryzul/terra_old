package io.wury.terra.gradle.java

plugins {
  id("io.wury.terra.gradle.terra-base")
  `java-base`
}

repositories {
  mavenCentral()
}

java {
  toolchain {
    version = "21"
  }
}