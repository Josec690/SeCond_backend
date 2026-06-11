package com.condominio.backend.vehicle

import com.condominio.backend.user.User
import jakarta.persistence.*

@Entity
@Table(name = "vehicles")
data class Vehicle(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true)
    var plate: String = "",

    var model: String = "",

    var color: String = "",

    @Enumerated(EnumType.STRING)
    var status: VehicleStatus =
        VehicleStatus.AUTHORIZED,

    @ManyToOne
    @JoinColumn(name = "resident_id")
    var resident: User? = null
)