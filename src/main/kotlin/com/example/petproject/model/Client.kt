package com.example.petproject.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0,
    val uuid: String? = null,
    var email: String? = null,
    val password: String? = null,
    val birth_date: LocalDateTime? = null,
    val first_name: String? = null,
    val last_name: String? = null,
    val created_at: LocalDateTime? = null,
    var updated_at: LocalDateTime? = null,

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    var vehicles: Set<Vehicle>? = null,

    @OneToMany(mappedBy = "owner", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    var contracts: Set<InsuranceContract>? = null
)
