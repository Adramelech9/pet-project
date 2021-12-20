package com.example.petproject.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.EnumType.STRING
import javax.persistence.Enumerated
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "insurance_kit")
class InsuranceKit: BaseEntity() {
    lateinit var duration: LocalDateTime
    val compensationPercent: Int = 0

    @Enumerated(STRING)
    lateinit var damageLevel: DamageLevel

    @Enumerated(STRING)
    lateinit var coveredPart: CoveredPart

    @ManyToMany
    @JoinTable(
        name = "contract_kit",
        joinColumns = [JoinColumn(name = "contract_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "kit_id", referencedColumnName = "id")]
    )
    var contracts: Set<InsuranceContract> = mutableSetOf()
}