package com.example.petproject.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "vehicle")
class Vehicle : BaseEntity() {
    var color: String? = null
    val engine_capacity: String? = null
    val year_of_manufacture: LocalDateTime? = null
    var weight_kg: Int? = 0

    @ManyToOne
    @JoinColumn(name = "client_id")
    var owner: Client? = null

    @OneToOne(fetch = FetchType.LAZY)
    var contractId: InsuranceContract? = null
}