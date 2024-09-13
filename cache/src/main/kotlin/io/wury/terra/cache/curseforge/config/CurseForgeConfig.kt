package io.wury.terra.cache.curseforge.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "terra.curseforge")
data class CurseForgeConfig(
    val apiKey: String,
    val root: String,
)