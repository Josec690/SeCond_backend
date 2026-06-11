package com.condominio.backend.vehicle

import org.springframework.data.jpa.repository.JpaRepository

interface VehicleRepository :
    JpaRepository<Vehicle, Long> {

    fun existsByPlate(
        plate: String
    ): Boolean
}