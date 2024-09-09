package com.cocot3ro.gestionhotel.core.controller

import reactor.core.publisher.Mono

interface ICoreController {

    fun status(): Mono<String>
}