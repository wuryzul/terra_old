package io.wury.terra.common.curseforge.config

import io.wury.terra.common.core.factory.WebClientFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class CurseForgeClientConfig {
    @Bean("curse-forge-web-client")
    fun webClient(
        curseForgeConfig: CurseForgeConfig,
        webClientFactory: WebClientFactory
    ): WebClient {
        return webClientFactory.createWebClient(curseForgeConfig.root, curseForgeConfig.apiKey)
    }
}