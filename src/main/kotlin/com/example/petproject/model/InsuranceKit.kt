package com.example.petproject.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "insurance_kit")
class InsuranceKit: BaseEntity() {
    var duration: LocalDateTime? = null
    val compensation_percent: Int? = null

    @Enumerated(EnumType.STRING)
    var damage_level: DamageLevel? = null

    @Enumerated(EnumType.STRING)
    var covered_part: CoveredPart? = null

    @ManyToOne
    @JoinColumn(name = "contract_id")
    var contract: InsuranceContract? = null
}