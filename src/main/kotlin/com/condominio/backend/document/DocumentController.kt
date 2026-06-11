package com.condominio.backend.document

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/documents")
class DocumentController(
private val service: DocumentService
) {

@PostMapping
fun create(
    @RequestBody document: Document
): Document {

    return service.create(document)
}

@GetMapping
fun findAll(): List<Document> {

    return service.findAll()
}

@DeleteMapping("/{id}")
fun delete(
    @PathVariable id: Long
) {

    service.delete(id)
}

}
