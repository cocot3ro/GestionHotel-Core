package com.cocot3ro.gestionhotel.core.controller.rest

import com.cocot3ro.gestionhotel.core.controller.IAlmacenController
import com.cocot3ro.gestionhotel.core.entities.AlmacenEntity
import com.cocot3ro.gestionhotel.core.service.AlmacenService
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class AlmacenRestController(private val almacenService: AlmacenService) : IAlmacenController {

    override fun all(): Flux<List<AlmacenEntity>> {
        return almacenService.all()
    }

    override fun saveAlmacenEntity(almacenEntity: AlmacenEntity): Mono<AlmacenEntity> {
        return Mono.just(almacenService.save(almacenEntity))
    }

    override fun updateAlmacenEntity(newAlmacenEntity: AlmacenEntity): Mono<AlmacenEntity> {
        return Mono.just(almacenService.update(newAlmacenEntity))
    }

    override fun deleteAlmacenEntity(id: Long) {
        almacenService.delete(id)
    }
}