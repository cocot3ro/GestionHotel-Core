package com.cocot3ro.gestionhotel.core.controller.rest

import com.cocot3ro.gestionhotel.core.controller.ICoreController
import com.cocot3ro.gestionhotel.core.service.CoreService
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class CoreRestController(private val coreService: CoreService) : ICoreController {
    override fun status(): Mono<String> {
        return coreService.status()
    }
}