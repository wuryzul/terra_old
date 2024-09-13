package io.wury.terra.cache.web.service

import io.wury.terra.common.core.model.ModModel
import io.wury.terra.cache.core.service.ModService
import io.wury.terra.cache.web.representation.mapper.GetModResponseMapper
import io.wury.terra.cache.web.representation.request.GetModsRequest
import io.wury.terra.cache.web.representation.response.GetModDescriptionResponse
import io.wury.terra.cache.web.representation.response.GetModResponse
import io.wury.terra.cache.web.representation.response.GetModsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class ModWebService(
    private val modService: ModService,
    private val getModResponseMapper: GetModResponseMapper,
) {
    fun ModModel.toGetModResponse(): GetModResponse =
        getModResponseMapper.convert(this)

    suspend fun Flow<ModModel>.toGetModsResponse(): GetModsResponse =
        GetModsResponse(this.toList(mutableListOf()).map { it.toGetModResponse() })

    fun String.toGetModDescriptionResponse(): GetModDescriptionResponse =
        GetModDescriptionResponse(this)

    suspend fun getAllMods(): GetModsResponse {
        return modService.getAllMods().toGetModsResponse()
    }

    suspend fun getMods(request: GetModsRequest): GetModsResponse {
        return modService.getMods(request.modIds).toGetModsResponse()
    }

    suspend fun getModByModId(modId: Int): GetModResponse? {
        return modService.getMod(modId)?.toGetModResponse()
    }

    suspend fun getModBySlug(slug: String): GetModResponse? {
        return modService.getModBySlug(slug)?.toGetModResponse()
    }

    suspend fun getModDescription(modId: Int): GetModDescriptionResponse? {
        return modService.getModDescription(modId)?.toGetModDescriptionResponse()
    }

    suspend fun getModDescriptionBySlug(slug: String): GetModDescriptionResponse? {
        return modService.getModDescriptionBySlug(slug)?.toGetModDescriptionResponse()
    }
}