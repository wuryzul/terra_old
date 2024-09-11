package io.wury.terra.web.service

import io.wury.terra.core.service.ModService
import io.wury.terra.web.mapper.CreateModRequestMapper
import io.wury.terra.web.mapper.CreateModResponseMapper
import io.wury.terra.web.mapper.GetModResponseMapper
import io.wury.terra.web.representation.request.CreateModRequest
import io.wury.terra.web.representation.response.CreateModResponse
import io.wury.terra.web.representation.response.GetModResponse
import io.wury.terra.web.representation.response.GetModsResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ModWebService(
    private val modService: ModService,
    private val createModRequestMapper: CreateModRequestMapper,
    private val createModResponseMapper: CreateModResponseMapper,
    private val getModResponseMapper: GetModResponseMapper,
) {
    fun createMod(request: CreateModRequest): Mono<CreateModResponse> {
        return modService.createMod(createModRequestMapper.convert(request)).map {
            createModResponseMapper.convert(it)
        }
    }

    fun getAllMods(): Mono<GetModsResponse> {
        return modService.getAllMods().map {
            getModResponseMapper.convert(it)
        }.collectList().map {
            GetModsResponse(it)
        }
    }

    fun getModById(id: Long): Mono<GetModResponse> {
        return modService.getModById(id).map {
            getModResponseMapper.convert(it)
        }
    }
}