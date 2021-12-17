package com.example.petproject.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Vehicle (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0,
    val uuid: String? = null,
    var color: String? = null,
    val engine_capacity: String? = null,
    val year_of_manufacture: LocalDateTime? = null,
    var weight_kg: Int? = 0,
    val created_at: LocalDateTime? = null,
    var updated_at: LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    var owner: Client? = null,

    @OneToOne(mappedBy = "id", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    var contractId: InsuranceContract? = null
)