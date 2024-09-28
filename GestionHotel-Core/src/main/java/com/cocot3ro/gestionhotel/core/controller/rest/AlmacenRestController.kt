package com.cocot3ro.gestionhotel.core.controller.rest

import com.cocot3ro.gestionhotel.core.controller.IAlmacenController
import com.cocot3ro.gestionhotel.core.entities.AlmacenEntity
import com.cocot3ro.gestionhotel.core.service.AlmacenService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/almacen")
class AlmacenRestController(private val almacenService: AlmacenService) : IAlmacenController {

    @GetMapping("/all")
    override fun all(): Flux<List<AlmacenEntity>> {
        return almacenService.all()
    }

    @PostMapping("/save")
    override fun saveAlmacenEntity(almacenEntity: AlmacenEntity): Mono<AlmacenEntity> {
        return Mono.just(almacenService.save(almacenEntity))
    }

    @PostMapping("/update")
    override fun updateAlmacenEntity(newAlmacenEntity: AlmacenEntity): Mono<AlmacenEntity> {
        return Mono.just(almacenService.update(newAlmacenEntity))
    }

    @DeleteMapping("/delete")
    override fun deleteAlmacenEntity(id: Long) {
        almacenService.delete(id)
    }
}