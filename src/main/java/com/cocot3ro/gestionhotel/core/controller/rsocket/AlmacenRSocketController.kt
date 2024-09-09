package com.cocot3ro.gestionhotel.core.controller.rsocket

import com.cocot3ro.gestionhotel.core.controller.IAlmacenController
import com.cocot3ro.gestionhotel.core.entities.AlmacenEntity
import com.cocot3ro.gestionhotel.core.service.AlmacenService
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Controller
class AlmacenRSocketController(private val service: AlmacenService) : IAlmacenController {

    @MessageMapping("/all")
    override fun all(): Flux<List<AlmacenEntity>> {
        return service.all()
    }

    @MessageMapping("/save")
    override fun saveAlmacenEntity(almacenEntity: AlmacenEntity): Mono<AlmacenEntity> {
        return Mono.just(service.save(almacenEntity))
    }

    @MessageMapping("/update")
    override fun updateAlmacenEntity(newAlmacenEntity: AlmacenEntity): Mono<AlmacenEntity> {
        return Mono.just(service.update(newAlmacenEntity))
    }

    @MessageMapping("/delete")
    override fun deleteAlmacenEntity(id: Long) {
        service.delete(id)
    }
}