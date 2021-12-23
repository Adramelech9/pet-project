package com.example.petproject.model

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
    var yearOfManufacture: Int = 0
    var weightKg: Int = 0

    @ManyToOne
    @JoinColumn(name = "client_id")
    lateinit var owner: Client

    @OneToOne(fetch = FetchType.LAZY)
    lateinit var contractId: InsuranceContract
}