package com.condominio.backend.document

import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class DocumentService(
private val repository: DocumentRepository
) {

// RN01 - Documento deve possuir nome
// RN02 - Documento deve possuir arquivo
// RN03 - Tipo do arquivo deve ser PDF ou imagem
fun create(
    document: Document
): Document {

    if (
        document.name.isBlank()
    ) {
        throw RuntimeException(
            "Nome obrigatório"
        )
    }

    if (
        document.data == null
    ) {
        throw RuntimeException(
            "Arquivo obrigatório"
        )
    }

    val allowedTypes =
        listOf(
            "application/pdf",
            "image/png",
            "image/jpeg"
        )

    if (
        !allowedTypes.contains(
            document.fileType
        )
    ) {
        throw RuntimeException(
            "Tipo de arquivo inválido"
        )
    }

    document.uploadedAt =
        LocalDateTime.now()

    return repository.save(document)
}

fun findAll(): List<Document> {
    return repository.findAll()
}

fun delete(id: Long) {

    val document =
        repository.findById(id)
            .orElseThrow {
                RuntimeException(
                    "Documento não encontrado"
                )
            }

    repository.delete(document)
}


}
