package com.example.petproject.repository

import com.example.petproject.model.Vehicle
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface VehicleRepository: CrudRepository<Vehicle, Long> {
}