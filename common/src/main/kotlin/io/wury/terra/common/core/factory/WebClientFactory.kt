package io.wury.terra.common.core.factory

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient

@Service
class WebClientFactory(
    private val exchangeStrategies: ExchangeStrategies,
) {
    fun createWebClient(baseUrl: String, apiKey: String? = null): WebClient {
        return WebClient.builder()
            .exchangeStrategies(exchangeStrategies)
            .baseUrl(baseUrl)
            .defaultHeaders { apiKey?.let { key -> it["x-api-key"] = key } }
            .build()
    }
}