package com.condominio.backend.visitor

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/visitors")
class VisitorController(
    private val service: VisitorService
) {

    @PostMapping
    fun create(
        @RequestBody visitor: Visitor
    ): Visitor {

        return service.create(visitor)
    }

    @PutMapping("/{id}/block")
    fun block(
        @PathVariable id: Long
    ): Visitor {

        return service.block(id)
    }

    @GetMapping
    fun findAll(): List<Visitor> {

        return service.findAll()
    }
}