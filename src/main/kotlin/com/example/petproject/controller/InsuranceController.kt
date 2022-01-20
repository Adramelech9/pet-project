package com.example.petproject.controller

import com.example.petproject.model.dto.InsuranceContractDto
import com.example.petproject.model.dto.InsuranceKitDto
import com.example.petproject.service.InsuranceContractService
import com.example.petproject.service.InsuranceKitService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/insurance")
class InsuranceController(
    private var insuranceKitService: InsuranceKitService,
    private var insuranceContractService: InsuranceContractService
) {

    @PostMapping("/kit")
    fun addInsuranceKit(@RequestBody insuranceKitDto: InsuranceKitDto) =
        insuranceKitService.addKit(insuranceKitDto)

    @PostMapping("/contract")
    fun addInsuranceContract(@RequestBody insuranceContractDto: InsuranceContractDto) =
        insuranceContractService.addContract(insuranceContractDto)
}
