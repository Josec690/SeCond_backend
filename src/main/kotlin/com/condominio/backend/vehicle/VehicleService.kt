package com.condominio.backend.vehicle

import org.springframework.stereotype.Service

@Service
class VehicleService(
    private val repository: VehicleRepository
) {

    fun create(
        vehicle: Vehicle
    ): Vehicle {

        if (
            repository.existsByPlate(
                vehicle.plate
            )
        ) {
            throw RuntimeException(
                "Placa já cadastrada"
            )
        }

        vehicle.status =
            VehicleStatus.AUTHORIZED

        return repository.save(vehicle)
    }

    fun block(
        id: Long
    ): Vehicle {

        val vehicle =
            repository.findById(id)
                .orElseThrow {
                    RuntimeException(
                        "Veículo não encontrado"
                    )
                }

        vehicle.status =
            VehicleStatus.BLOCKED

        return repository.save(vehicle)
    }

    fun authorize(
        id: Long
    ): Vehicle {

        val vehicle =
            repository.findById(id)
                .orElseThrow {
                    RuntimeException(
                        "Veículo não encontrado"
                    )
                }

        vehicle.status =
            VehicleStatus.AUTHORIZED

        return repository.save(vehicle)
    }

    fun findAll(): List<Vehicle> {
        return repository.findAll()
    }
}