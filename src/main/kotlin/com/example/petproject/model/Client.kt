package com.example.petproject.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.FetchType.LAZY
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "client")
class Client : BaseEntity() {

    var email: String = ""
    val password: String = ""
    lateinit var birthDate: LocalDateTime
    val firstName: String = ""
    val lastName: String = ""

    @OneToMany(mappedBy = "owner", fetch = LAZY)
    var vehicles: Set<Vehicle> = mutableSetOf()

    @OneToMany(mappedBy = "owner", fetch = LAZY)
    var contracts: Set<InsuranceContract> = mutableSetOf()
}
