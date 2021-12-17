package com.example.petproject.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "insurance_Contract")
data class InsuranceContract (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0,
    val uuid: String? = null,
    val created_at: LocalDateTime? = null,
    var updated_at: LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    var owner: Client? = null,

    @OneToMany(mappedBy = "id", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    @JoinColumn(name = "kit_id")
    var kits: Set<InsuranceKit>? = null

)