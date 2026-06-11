package com.condominio.backend.document

import org.springframework.data.jpa.repository.JpaRepository

interface DocumentRepository :
JpaRepository<Document, Long>
