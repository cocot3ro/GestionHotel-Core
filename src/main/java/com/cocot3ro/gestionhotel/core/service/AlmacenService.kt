package com.cocot3ro.gestionhotel.core.service

import com.cocot3ro.gestionhotel.core.entities.AlmacenEntity
import com.cocot3ro.gestionhotel.core.persistence.AlmacenJPARepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.Duration

@Service
class AlmacenService(private val almacenJPARepository: AlmacenJPARepository) {

    fun all(): Flux<List<AlmacenEntity>> {
        return Flux.interval(Duration.ofSeconds(1)).map {
            almacenJPARepository.findAll().toList()
        }
    }

    fun save(almacenEntity: AlmacenEntity): AlmacenEntity {
        return almacenJPARepository.save(almacenEntity)
    }

    fun update(newAlmacenEntity: AlmacenEntity): AlmacenEntity {
        return almacenJPARepository.findById(newAlmacenEntity.id)
            .map { almacenEntity: AlmacenEntity ->
                almacenEntity.nombre = newAlmacenEntity.nombre
                almacenEntity.cantidad = newAlmacenEntity.cantidad
                almacenEntity.minimo = newAlmacenEntity.minimo
                almacenEntity.pack = newAlmacenEntity.pack
                return@map almacenJPARepository.save(almacenEntity)
            }
            .orElseGet {
                newAlmacenEntity.id = 0L
                return@orElseGet almacenJPARepository.save(newAlmacenEntity)
            }
    }

    fun delete(id: Long) {
        almacenJPARepository.deleteById(id)
    }
}
