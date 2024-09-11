package io.wury.terra.web.controller

import io.wury.terra.web.representation.request.CreateModRequest
import io.wury.terra.web.representation.response.CreateModResponse
import io.wury.terra.web.representation.response.GetModResponse
import io.wury.terra.web.representation.response.GetModsResponse
import io.wury.terra.web.service.ModWebService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/mod")
class ModController(
    private val modWebService: ModWebService,
) {
    @PostMapping("/create")
    fun createMod(@RequestBody request: CreateModRequest): Mono<CreateModResponse> {
        return modWebService.createMod(request)
    }

    @GetMapping
    fun getAllMods(): Mono<GetModsResponse> {
        return modWebService.getAllMods()
    }

    @GetMapping("/{id}")
    fun getModById(@PathVariable id: Long): Mono<GetModResponse> {
        return modWebService.getModById(id)
    }
}