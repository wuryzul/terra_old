package io.wury.terra.web.controller

import io.wury.terra.web.representation.response.GetFileResponse
import io.wury.terra.web.service.FileWebService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@RestController
@RequestMapping("/api/mod")
class FileController(
    private val fileWebService: FileWebService,
) {
    fun <T : Any> Mono<T>.handleError(): Mono<T> =
        onErrorMap {
            ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error: ${it.stackTraceToString()}")
        }.switchIfEmpty {
            Mono.error(ResponseStatusException(HttpStatus.NOT_FOUND))
        }.doOnError { throw it }

    @GetMapping("/{modId}/file/{fileId}")
    fun getFile(@PathVariable modId: Int, @PathVariable fileId: Int): Mono<GetFileResponse> {
        return fileWebService.getFile(modId, fileId).handleError()
    }
}