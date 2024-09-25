package com.cocot3ro.gestionhotel.core.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.Date

@Service
class CoreService {

    fun status(): Mono<String> {
        return Mono.just(Date().toString())
    }
}