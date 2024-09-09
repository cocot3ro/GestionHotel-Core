package com.cocot3ro.gestionhotel.core.controller.rsocket

import com.cocot3ro.gestionhotel.core.controller.ICoreController
import com.cocot3ro.gestionhotel.core.service.CoreService
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Mono

@Controller
class CoreRSocketController(private val service: CoreService) : ICoreController{

    @MessageMapping("/status")
    override fun status(): Mono<String> {
        return service.status()
    }

}