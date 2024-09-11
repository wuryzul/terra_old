package io.wury.terra.gradle

plugins {
  id("io.wury.terra.gradle.terra-base")
  id("com.github.node-gradle.node")
}

node {
  download = true
}