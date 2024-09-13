package io.wury.terra.cache.web.service

import io.wury.terra.common.core.model.FileModel
import io.wury.terra.cache.core.service.FileService
import io.wury.terra.common.web.representation.mapper.GetFileResponseMapper
import io.wury.terra.common.web.representation.response.GetFileResponse
import org.springframework.stereotype.Service

@Service
class FileWebService(
    private val fileService: FileService,
    private val getFileResponseMapper: GetFileResponseMapper
) {
    fun FileModel.toResponse(): GetFileResponse =
        getFileResponseMapper.convert(this)

    suspend fun getFile(modId: Int, fileId: Int): GetFileResponse? {
        return fileService.getFile(modId, fileId)?.toResponse()
    }
}