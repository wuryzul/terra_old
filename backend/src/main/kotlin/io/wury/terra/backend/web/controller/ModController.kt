package io.wury.terra.backend.web.controller

import io.wury.terra.backend.client.service.ModService
import io.wury.terra.common.web.representation.mapper.GetModResponseMapper
import io.wury.terra.common.web.representation.response.GetModResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/mod")
class ModController(
    private val modService: ModService,
    private val getModResponseMapper: GetModResponseMapper,
) {
    @GetMapping("/{modId}")
    suspend fun getMod(@PathVariable modId: Int): GetModResponse {
        return getModResponseMapper.convert(
            modService.getMod(modId)
        )
    }

    @GetMapping("/slug/{slug}")
    suspend fun getMod(@PathVariable slug: String): GetModResponse {
        return getModResponseMapper.convert(
            modService.getMod(slug)
        )
    }
}