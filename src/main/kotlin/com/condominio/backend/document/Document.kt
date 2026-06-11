package com.condominio.backend.document

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "documents")
data class Document(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var name: String = "",

    var fileType: String = "",

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    var data: ByteArray? = null,

    var uploadedAt: LocalDateTime =
        LocalDateTime.now()
)