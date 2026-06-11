package com.condominio.backend.notice

import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class NoticeService(
    private val repository: NoticeRepository
) {

    // RN01 - Aviso deve possuir título
    // RN02 - Aviso deve possuir conteúdo
    // RN03 - Avisos possuem data automática
    fun create(
        notice: Notice
    ): Notice {

        if (
            notice.title.isBlank()
        ) {
            throw RuntimeException(
                "Título obrigatório"
            )
        }

        if (
            notice.content.isBlank()
        ) {
            throw RuntimeException(
                "Conteúdo obrigatório"
            )
        }

        notice.createdAt =
            LocalDateTime.now()

        return repository.save(notice)
    }

    fun findAll(): List<Notice> {
        return repository.findAll()
    }

    fun delete(id: Long) {

        val notice =
            repository.findById(id)
                .orElseThrow {
                    RuntimeException(
                        "Aviso não encontrado"
                    )
                }

        repository.delete(notice)
    }
}