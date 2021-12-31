package com.example.petproject.controller

import com.example.petproject.model.dto.ClientDto
import com.example.petproject.service.ClientService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ClientController(
    private var clientService: ClientService
) {

    @PostMapping("/user")
    fun addUser(@RequestBody clientDto: ClientDto) = clientService.addClient(clientDto)
}