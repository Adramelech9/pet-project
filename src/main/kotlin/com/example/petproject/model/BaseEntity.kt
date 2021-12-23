package com.example.petproject.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.util.UUID.randomUUID
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.AUTO
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = AUTO)
    val id: Long = 0
    val uuid: String = randomUUID().toString()
    @CreatedDate
    lateinit var createdAt: LocalDateTime
    @LastModifiedDate
    lateinit var updatedAt: LocalDateTime
}