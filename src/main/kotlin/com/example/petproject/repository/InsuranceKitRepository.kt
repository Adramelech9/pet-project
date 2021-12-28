package com.example.petproject.repository

import com.example.petproject.model.InsuranceKit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InsuranceKitRepository: JpaRepository<InsuranceKit, Long> {

    fun findByIdIn(id: List<Long>): Set<InsuranceKit>
}