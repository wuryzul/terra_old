package io.wury.terra.common.core.config

import io.wury.terra.common.core.factory.WebClientFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class TerraWebClientConfig {
    @Bean("terra-web-client")
    fun webClient(terraClientConfig: TerraClientConfig, webClientFactory: WebClientFactory): WebClient {
        return webClientFactory.createWebClient(terraClientConfig.root)
    }
}