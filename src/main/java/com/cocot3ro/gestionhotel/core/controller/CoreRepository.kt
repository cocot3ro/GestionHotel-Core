package com.cocot3ro.gestionhotel.core.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CoreRepository {

    @GetMapping("/ping")
    fun ping(): String {
        return "pong"
    }
}