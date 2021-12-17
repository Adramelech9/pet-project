package com.example.petproject.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Vehicle : RequiredAttributes() {
    var color: String? = null
    val engine_capacity: String? = null
    val year_of_manufacture: LocalDateTime? = null
    var weight_kg: Int? = 0

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    var owner: Client? = null

    @OneToOne(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    var contractId: InsuranceContract? = null
}