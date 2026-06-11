package com.condominio.backend.visitor

import org.springframework.data.jpa.repository.JpaRepository

interface VisitorRepository :
    JpaRepository<Visitor, Long>