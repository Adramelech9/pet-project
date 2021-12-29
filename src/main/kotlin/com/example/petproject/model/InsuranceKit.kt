package com.example.petproject.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.EnumType.STRING
import javax.persistence.Enumerated
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "insurance_kit")
class InsuranceKit: BaseEntity() {
    lateinit var duration: LocalDateTime
    var compensationPercent: Int = 0

    @Enumerated(STRING)
    lateinit var damageLevel: DamageLevel

    @Enumerated(STRING)
    lateinit var coveredPart: CoveredPart

    @ManyToMany(mappedBy = "kits")
    var contracts = mutableSetOf<InsuranceContract>()
}