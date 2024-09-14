package io.wury.terra.common.client.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("terra.client")
data class TerraClientConfig(
    val root: String
)