package io.wury.terra.web.controller

import io.wury.terra.web.representation.response.GetFileResponse
import io.wury.terra.web.service.FileWebService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/mod")
class FileController(
    private val fileWebService: FileWebService,
) {
    @GetMapping("/{modId}/file/{fileId}")
    suspend fun getFile(@PathVariable modId: Int, @PathVariable fileId: Int): GetFileResponse {
        try {
            return fileWebService.getFile(modId, fileId)!!
        } catch (e: NullPointerException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, e.stackTraceToString())
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.stackTraceToString())
        }
    }
}