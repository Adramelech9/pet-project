package com.example.petproject.model

import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class RequiredAttributes (
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0,
    val uuid: String? = null,
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null
)