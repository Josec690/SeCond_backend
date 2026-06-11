package com.condominio.backend.visitor

import com.condominio.backend.user.User
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "visitors")
data class Visitor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var name: String = "",

    var document: String = "",

    @Enumerated(EnumType.STRING)
    var type: VisitorType =
        VisitorType.VISITOR,

    @Enumerated(EnumType.STRING)
    var status: VisitorStatus =
        VisitorStatus.ACTIVE,

    var validUntil: LocalDateTime? = null,

    @ManyToOne
    @JoinColumn(name = "resident_id")
    var resident: User? = null
)