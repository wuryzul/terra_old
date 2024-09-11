package io.wury.terra.core.service

import io.wury.terra.core.mapper.ModEntityToModelMapper
import io.wury.terra.core.mapper.ModModelToEntityMapper
import io.wury.terra.core.model.ModModel
import io.wury.terra.db.repository.ModRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ModService(
    private val modRepository: ModRepository,
    private val modEntityToModelMapper: ModEntityToModelMapper,
    private val modModelToEntityMapper: ModModelToEntityMapper,
) {
    fun createMod(mod: ModModel): Mono<ModModel> {
        return modRepository.save(modModelToEntityMapper.convert(mod)).map {
            modEntityToModelMapper.convert(it)
        }
    }

    fun getAllMods(): Flux<ModModel> {
        return modRepository.findAll().map {
            modEntityToModelMapper.convert(it)
        }
    }

    fun getModById(id: Long): Mono<ModModel> {
        return modRepository.findById(id).map {
            modEntityToModelMapper.convert(it)
        }
    }
}