package io.wury.terra.backend.client.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "terra.client")
data class TerraClientConfig(
    val root: String
)
