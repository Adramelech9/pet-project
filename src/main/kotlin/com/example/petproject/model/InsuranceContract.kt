package com.example.petproject.model

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "insurance_contract")
class InsuranceContract: BaseEntity() {

    @ManyToOne
    @JoinColumn(name = "client_id")
    lateinit var owner: Client

    @ManyToMany(mappedBy = "contracts")
    var kits: Set<InsuranceKit> = mutableSetOf()
}