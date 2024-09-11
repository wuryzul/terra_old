package io.wury.terra.curseforge.service

import io.wury.terra.curseforge.config.CurseForgeConfig
import jakarta.ws.rs.client.WebTarget
import jakarta.ws.rs.container.ContainerRequestFilter
import org.glassfish.jersey.client.JerseyClient
import org.glassfish.jersey.client.JerseyClientBuilder
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JerseyClientConfiguration(
    private val curseForgeConfig: CurseForgeConfig,
) {
    @Bean
    fun createClient(@Qualifier("apiFilter") apiFilter: ContainerRequestFilter): JerseyClient {
        return JerseyClientBuilder()
            .register(apiFilter)
            .build()
    }

    @Bean(name = ["apiFilter"])
    fun createApiFilter(): ContainerRequestFilter {
        return ContainerRequestFilter { context ->
            context.headers.add("x-api-key", curseForgeConfig.apiKey)
        }
    }

    @Bean(name = ["curseForgeRoot"])
    fun createRoot(jerseyClient: JerseyClient): WebTarget {
        return jerseyClient.target(curseForgeConfig.root)
    }
}