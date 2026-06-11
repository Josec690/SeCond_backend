package com.condominio.backend.notice

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notices")
class NoticeController(
    private val service: NoticeService
) {

    @PostMapping
    fun create(
        @RequestBody notice: Notice
    ): Notice {

        return service.create(notice)
    }

    @GetMapping
    fun findAll(): List<Notice> {

        return service.findAll()
    }

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: Long
    ) {

        service.delete(id)
    }
}