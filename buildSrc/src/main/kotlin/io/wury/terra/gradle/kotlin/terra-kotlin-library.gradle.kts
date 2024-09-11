package io.wury.terra.gradle.kotlin

plugins {
  id("io.wury.terra.gradle.kotlin.terra-kotlin-common")
  id("io.wury.terra.gradle.java.terra-java-library")
}

dependencies {
  implementation(kotlin("reflect"))
}