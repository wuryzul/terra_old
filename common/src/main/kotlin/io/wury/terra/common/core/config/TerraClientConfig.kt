package io.wury.terra.common.core.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("terra.client")
data class TerraClientConfig(val root: String)