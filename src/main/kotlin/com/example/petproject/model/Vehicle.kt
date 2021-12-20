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
    var color: String = ""
    val engineCapacity: String = ""
    lateinit var yearOfManufacture: LocalDateTime
    var weightKg: Int = 0

    @ManyToOne
    @JoinColumn(name = "client_id")
    lateinit var owner: Client

    @OneToOne(fetch = FetchType.LAZY)
    lateinit var contractId: InsuranceContract
}