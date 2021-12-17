package com.example.petproject.repository

import com.example.petproject.model.InsuranceContract
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InsuranceContractRepository: CrudRepository<InsuranceContract, Long> {
}