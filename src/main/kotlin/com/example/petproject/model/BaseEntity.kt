package com.example.petproject.model

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity (
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0,
    val uuid: String? = null,
    @CreatedDate
    var created_at: LocalDateTime? = LocalDateTime.of(1900, 1, 1, 0, 0),
    @CreatedDate
    var updated_at: LocalDateTime? = LocalDateTime.of(1900, 1, 1, 0, 0)
)