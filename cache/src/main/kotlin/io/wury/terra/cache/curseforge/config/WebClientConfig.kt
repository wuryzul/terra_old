package io.wury.terra.cache.curseforge.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {
    @Bean
    fun exchangeStrategies(objectMapper: ObjectMapper): ExchangeStrategies {
        return ExchangeStrategies.builder()
            .codecs {
                it.defaultCodecs().jackson2JsonEncoder(Jackson2JsonEncoder(objectMapper, MediaType.APPLICATION_JSON))
                it.defaultCodecs().jackson2JsonDecoder(Jackson2JsonDecoder(objectMapper, MediaType.APPLICATION_JSON))
            }
            .build()
    }

    @Bean
    fun webClient(exchangeStrategies: ExchangeStrategies, curseForgeConfig: CurseForgeConfig): WebClient {
        return WebClient.builder()
            .exchangeStrategies(exchangeStrategies)
            .baseUrl(curseForgeConfig.root)
            .defaultHeaders { it["x-api-key"] = curseForgeConfig.apiKey }
            .build()
    }
}