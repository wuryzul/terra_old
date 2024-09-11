package io.wury.terra.curseforge.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "terra.curseforge")
data class CurseForgeConfig(
    val apiKey: String? = null,
    val root: String? = null,
)