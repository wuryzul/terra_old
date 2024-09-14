package io.wury.terra.cache.web.service

import io.wury.terra.common.core.model.ModModel
import io.wury.terra.cache.core.service.CacheModService
import io.wury.terra.common.web.representation.mapper.GetModResponseMapper
import io.wury.terra.common.web.representation.request.GetModsRequest
import io.wury.terra.common.web.representation.response.GetModDescriptionResponse
import io.wury.terra.common.web.representation.response.GetModResponse
import io.wury.terra.common.web.representation.response.GetModsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class ModWebService(
    private val cacheModService: CacheModService,
    private val getModResponseMapper: GetModResponseMapper,
) {
    fun ModModel.toGetModResponse(): GetModResponse =
        getModResponseMapper.convert(this)

    suspend fun Flow<ModModel>.toGetModsResponse(): GetModsResponse =
        GetModsResponse(this.toList(mutableListOf()).map { it.toGetModResponse() })

    fun String.toGetModDescriptionResponse(): GetModDescriptionResponse =
        GetModDescriptionResponse(this)

    suspend fun getAllMods(): GetModsResponse {
        return cacheModService.getAllMods().toGetModsResponse()
    }

    suspend fun getMods(request: GetModsRequest): GetModsResponse {
        return cacheModService.getMods(request.modIds).toGetModsResponse()
    }

    suspend fun getModByModId(modId: Int): GetModResponse? {
        return cacheModService.getMod(modId)?.toGetModResponse()
    }

    suspend fun getModBySlug(slug: String): GetModResponse? {
        return cacheModService.getModBySlug(slug)?.toGetModResponse()
    }

    suspend fun getModDescription(modId: Int): GetModDescriptionResponse? {
        return cacheModService.getModDescription(modId)?.toGetModDescriptionResponse()
    }

    suspend fun getModDescriptionBySlug(slug: String): GetModDescriptionResponse? {
        return cacheModService.getModDescriptionBySlug(slug)?.toGetModDescriptionResponse()
    }
}