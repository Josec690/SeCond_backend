package com.condominio.backend.notice

import org.springframework.data.jpa.repository.JpaRepository

interface NoticeRepository :
    JpaRepository<Notice, Long>