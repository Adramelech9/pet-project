package com.example.petproject.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "client")
class Client : BaseEntity() {

    var email: String? = ""
    val password: String? = ""
    var birth_date: LocalDateTime? = LocalDateTime.of(1900, 1, 1, 0, 0)
    val first_name: String? = ""
    val last_name: String? = ""

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    var vehicles: Set<Vehicle>? = null

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    var contracts: Set<InsuranceContract>? = null
}
