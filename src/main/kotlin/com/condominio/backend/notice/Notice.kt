package com.condominio.backend.notice

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "notices")
data class Notice(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var title: String = "",

    @Column(columnDefinition = "TEXT")
    var content: String = "",

    var createdAt: LocalDateTime =
        LocalDateTime.now()
)