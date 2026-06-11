package com.condominio.backend.vehicle

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/vehicles")
class VehicleController(
    private val service: VehicleService
) {

    @PostMapping
    fun create(
        @RequestBody vehicle: Vehicle
    ): Vehicle {

        return service.create(vehicle)
    }

    @PutMapping("/{id}/block")
    fun block(
        @PathVariable id: Long
    ): Vehicle {

        return service.block(id)
    }

    @PutMapping("/{id}/authorize")
    fun authorize(
        @PathVariable id: Long
    ): Vehicle {

        return service.authorize(id)
    }

    @GetMapping
    fun findAll(): List<Vehicle> {

        return service.findAll()
    }
}