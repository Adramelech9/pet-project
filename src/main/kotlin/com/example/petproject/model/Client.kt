package com.example.petproject.model

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.FetchType.LAZY
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "client")
class Client : BaseEntity() {

    var email: String = ""
    var password: String = ""
    lateinit var birthDate: LocalDate
    var firstName: String = ""
    var lastName: String = ""

    @OneToMany(mappedBy = "owner", fetch = LAZY)
    var vehicles: Set<Vehicle> = mutableSetOf()

    @OneToMany(mappedBy = "owner", fetch = LAZY)
    var contracts: Set<InsuranceContract> = mutableSetOf()
}
