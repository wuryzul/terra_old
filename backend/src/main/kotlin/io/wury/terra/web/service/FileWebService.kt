package io.wury.terra.web.service

import io.wury.terra.core.model.FileModel
import io.wury.terra.core.service.FileService
import io.wury.terra.web.mapper.GetFileResponseMapper
import io.wury.terra.web.representation.response.GetFileResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class FileWebService(
    private val fileService: FileService,
    private val getFileResponseMapper: GetFileResponseMapper
) {
    fun Mono<FileModel>.toGetFileResponse(): Mono<GetFileResponse> =
        map(getFileResponseMapper::convert)

    fun getFile(modId: Int, fileId: Int): Mono<GetFileResponse> {
        return fileService.getFile(modId, fileId).toGetFileResponse()
    }
}