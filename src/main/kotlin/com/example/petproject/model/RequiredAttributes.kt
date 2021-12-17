package com.example.petproject.model

import java.time.LocalDateTime


abstract class RequiredAttributes {
    abstract val id: Long
    abstract val uuid: String
    abstract val created_at: LocalDateTime
    abstract var updated_at: LocalDateTime
}