package io.wury.terra.cache.web.controller

import io.wury.terra.cache.web.representation.request.GetModsRequest
import io.wury.terra.cache.web.representation.response.GetModDescriptionResponse
import io.wury.terra.cache.web.representation.response.GetModResponse
import io.wury.terra.cache.web.representation.response.GetModsResponse
import io.wury.terra.cache.web.service.ModWebService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/mod")
class ModController(
    private val modWebService: ModWebService,
) {
    suspend fun <T : Any> handleError(block: suspend () -> T?): T {
        try {
            return block()!!
        } catch (e: NullPointerException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, e.stackTraceToString())
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.stackTraceToString())
        }
    }

    @GetMapping
    suspend fun getAllMods(): GetModsResponse {
        return modWebService.getAllMods()
    }

    @PostMapping
    suspend fun getMods(@RequestBody request: GetModsRequest): GetModsResponse {
        return modWebService.getMods(request)
    }

    @GetMapping("/{modId}")
    suspend fun getModById(@PathVariable modId: Int): GetModResponse {
        return handleError { modWebService.getModByModId(modId) }
    }

    @GetMapping("/slug/{slug}")
    suspend fun getModBySlug(@PathVariable slug: String): GetModResponse {
        return handleError { modWebService.getModBySlug(slug) }
    }

    @GetMapping("/{modId}/description")
    suspend fun getModDescription(@PathVariable modId: Int): GetModDescriptionResponse {
        return handleError { modWebService.getModDescription(modId) }
    }

    @GetMapping("/slug/{slug}/description")
    suspend fun getModDescriptionBySlug(@PathVariable slug: String): GetModDescriptionResponse {
        return handleError { modWebService.getModDescriptionBySlug(slug) }
    }
}