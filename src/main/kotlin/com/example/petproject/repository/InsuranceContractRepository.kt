package com.example.petproject.repository

import com.example.petproject.model.InsuranceContract
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InsuranceContractRepository : JpaRepository<InsuranceContract, Long>
