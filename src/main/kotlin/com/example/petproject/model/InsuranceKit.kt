package com.example.petproject.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "insurance_kit")
class InsuranceKit: RequiredAttributes() {
    var duration: LocalDateTime? = null
    val compensation_percent: Int? = null

    @Enumerated(EnumType.STRING)
    var damage_level: DamageLevel? = null

    @Enumerated(EnumType.STRING)
    var covered_part: CoveredPart? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contract_id")
    var contract: InsuranceContract? = null
}