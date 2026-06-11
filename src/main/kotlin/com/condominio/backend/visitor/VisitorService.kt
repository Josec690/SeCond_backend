package com.condominio.backend.visitor

import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class VisitorService(
    private val repository: VisitorRepository
) {

    fun create(
        visitor: Visitor
    ): Visitor {

        if (visitor.resident == null) {
            throw RuntimeException(
                "Visitante deve possuir morador responsável"
            )
        }

        if (
            visitor.validUntil != null &&
            visitor.validUntil!!.isBefore(
                LocalDateTime.now()
            )
        ) {
            throw RuntimeException(
                "Visitante expirado"
            )
        }

        visitor.status =
            VisitorStatus.ACTIVE

        return repository.save(visitor)
    }

    fun block(
        id: Long
    ): Visitor {

        val visitor =
            repository.findById(id)
                .orElseThrow {
                    RuntimeException(
                        "Visitante não encontrado"
                    )
                }

        visitor.status =
            VisitorStatus.BLOCKED

        return repository.save(visitor)
    }

    fun findAll(): List<Visitor> {
        return repository.findAll()
    }
}