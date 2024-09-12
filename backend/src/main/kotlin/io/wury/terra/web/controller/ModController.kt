package io.wury.terra.web.controller

import io.wury.terra.web.representation.request.GetModsRequest
import io.wury.terra.web.representation.response.GetModDescriptionResponse
import io.wury.terra.web.representation.response.GetModResponse
import io.wury.terra.web.representation.response.GetModsResponse
import io.wury.terra.web.service.ModWebService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@RestController
@RequestMapping("/api/mod")
class ModController(
    private val modWebService: ModWebService,
) {
    fun <T : Any> Mono<T>.handleError(): Mono<T> =
        onErrorMap {
            ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error: ${it.stackTraceToString()}")
        }.switchIfEmpty {
            Mono.error(ResponseStatusException(HttpStatus.NOT_FOUND))
        }.doOnError { throw it }

    @GetMapping
    fun getAllMods(): Mono<GetModsResponse> {
        return modWebService.getAllMods().handleError()
    }

    @PostMapping
    fun getMods(@RequestBody request: GetModsRequest): Mono<GetModsResponse> {
        return modWebService.getMods(request).handleError()
    }

    @GetMapping("/{id}")
    fun getModById(@PathVariable id: Long): Mono<GetModResponse> {
        return modWebService.getModById(id).handleError()
    }

    @GetMapping("/cf/{curseForgeID}")
    fun getModByCurseForgeID(@PathVariable curseForgeID: Long): Mono<GetModResponse> {
        return modWebService.getModByCurseForgeID(curseForgeID).handleError()
    }

    @GetMapping("/slug/{slug}")
    fun getModBySlug(@PathVariable slug: String): Mono<GetModResponse> {
        return modWebService.getModBySlug(slug).handleError()
    }

    @GetMapping("/{modId}/description")
    fun getModDescription(@PathVariable modId: Long): Mono<GetModDescriptionResponse> {
        return modWebService.getModDescription(modId).handleError()
    }

    @GetMapping("/cf/{curseForgeID}/description")
    fun getModDescriptionByCurseForgeID(@PathVariable curseForgeID: Long): Mono<GetModDescriptionResponse> {
        return modWebService.getModDescriptionByCurseForgeID(curseForgeID).handleError()
    }

    @GetMapping("/slug/{slug}/description")
    fun getModDescriptionBySlug(@PathVariable slug: String): Mono<GetModDescriptionResponse> {
        return modWebService.getModDescriptionBySlug(slug).handleError()
    }
}