package com.example.petproject.repository

import com.example.petproject.model.InsuranceKit
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InsuranceKitRepository: CrudRepository<InsuranceKit, Long> {
}