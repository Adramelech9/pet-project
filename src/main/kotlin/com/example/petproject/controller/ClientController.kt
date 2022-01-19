package com.example.petproject.controller

import com.example.petproject.model.dto.ClientDto
import com.example.petproject.service.ClientService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/clients")
class ClientController(private var clientService: ClientService) {

    @PostMapping
    fun addClient(@RequestBody clientDto: ClientDto) =
        clientService.addClient(clientDto)

    @GetMapping
    fun showAllClients() =
        clientService.findShortClients()

    @GetMapping("/{id}")
    fun showClientsDetail(@PathVariable id: Long) =
        clientService.showClientById(id)
}
