package com.cocot3ro.gestionhotel.msvc.almacen.controller

import com.cocot3ro.gestionhotel.msvc.almacen.entities.AlmacenEntity
import com.cocot3ro.gestionhotel.msvc.almacen.persistence.AlmacenJPARepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import java.time.Duration

@RestController
@RequestMapping("/api/almacen")
class AlmacenRestRepository(private val almacenJPARepository: AlmacenJPARepository) {

    @GetMapping(
        value = ["/all"],
        produces = [MediaType.TEXT_EVENT_STREAM_VALUE]
    )
    fun all(): Flux<List<AlmacenEntity>> {
        return Flux.interval(Duration.ofSeconds(1)).map {
            almacenJPARepository.findAll().toList()
        }
    }

    @PostMapping("/create")
    fun newAlmacenEntity(@RequestBody almacenEntity: AlmacenEntity): AlmacenEntity {
        return almacenJPARepository.save(almacenEntity)
    }

    @PutMapping("/update/{id}")
    fun replaceAlmacenEntity(@RequestBody newAlmacenEntity: AlmacenEntity, @PathVariable id: Long): AlmacenEntity {
        return almacenJPARepository.findById(id)
            .map { almacenEntity: AlmacenEntity ->
                almacenEntity.nombre = newAlmacenEntity.nombre
                almacenEntity.cantidad = newAlmacenEntity.cantidad
                almacenEntity.minimo = newAlmacenEntity.minimo
                almacenEntity.pack = newAlmacenEntity.pack
                return@map almacenJPARepository.save(almacenEntity)
            }
            .orElseGet {
                newAlmacenEntity.id = id
                return@orElseGet almacenJPARepository.save(newAlmacenEntity)
            }
    }

    @DeleteMapping("/delete/{id}")
    fun deleteAlmacenEntity(@PathVariable id: Long) {
        almacenJPARepository.deleteById(id)
    }
}