package io.wury.terra.gradle.java

plugins {
  id("io.wury.terra.gradle.java.terra-java-common")
  `java-library`
}

java {
  withSourcesJar()
  withJavadocJar()
}