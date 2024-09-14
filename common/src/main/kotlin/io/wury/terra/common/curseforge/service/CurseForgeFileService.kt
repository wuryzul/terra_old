package io.wury.terra.common.curseforge.service

import io.wury.terra.common.model.FileModel
import io.wury.terra.common.curseforge.model.mapper.CurseForgeFileMapper
import io.wury.terra.common.curseforge.representation.response.GetFileResponse
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class CurseForgeFileService(
    @Qualifier("curse-forge-web-client")
    private val webClient: WebClient,
    private val curseForgeFileMapper: CurseForgeFileMapper
) {
    suspend fun getFile(modId: Int, fileId: Int): FileModel {
        return curseForgeFileMapper.convert(
            webClient.get()
                .uri("/mods/$modId/files/$fileId")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .awaitBody<GetFileResponse>()
                .data
        )
    }
}