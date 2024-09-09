package com.cocot3ro.gestionhotel.core.controller

import com.cocot3ro.gestionhotel.core.entities.AlmacenEntity
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface IAlmacenController {

    fun all(): Flux<List<AlmacenEntity>>

    fun saveAlmacenEntity(almacenEntity: AlmacenEntity): Mono<AlmacenEntity>

    fun updateAlmacenEntity(newAlmacenEntity: AlmacenEntity): Mono<AlmacenEntity>

    fun deleteAlmacenEntity(id: Long)
}