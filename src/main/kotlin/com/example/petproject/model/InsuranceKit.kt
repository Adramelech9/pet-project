package com.example.petproject.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "insurance_kit")
data class InsuranceKit (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0,
    val uuid: String? = null,
    var duration: LocalDateTime? = null,
    val compensation_percent: Int? = null,
    val damage_level: String? = null,
    var covered_part: String? = null,
    val created_at: LocalDateTime? = null,
    var updated_at: LocalDateTime? = null
)