package io.wury.terra.common.curseforge.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("terra.curseforge")
data class CurseForgeConfig(
    val root: String,
    val apiKey: String? = null
)
