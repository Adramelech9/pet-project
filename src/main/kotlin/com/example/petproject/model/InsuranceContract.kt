package com.example.petproject.model

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "insurance_Contract")
class InsuranceContract: RequiredAttributes() {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    var owner: Client? = null

    @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY)
    var kits: Set<InsuranceKit>? = null

}