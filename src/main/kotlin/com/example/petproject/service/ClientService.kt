package com.example.petproject.service

import com.example.petproject.model.Client
import com.example.petproject.model.dto.ClientDto
import com.example.petproject.model.dto.ShortClientDto
import com.example.petproject.repository.ClientRepository
import com.example.petproject.transformer.ClientTransformer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaBuilder

@Service
class ClientService(
    private val clientRepository: ClientRepository,
    private val clientTransformer: ClientTransformer
) {

    @Autowired
    private lateinit var entityManager: EntityManager

    fun addClient(clientDto: ClientDto) =
        clientRepository.save(clientTransformer.transform(clientDto)).id

    fun showAllClients(): List<ShortClientDto> {
        val cb: CriteriaBuilder = entityManager.criteriaBuilder
        val cq = cb.createQuery(ShortClientDto::class.java)
        val root = cq.from(Client::class.java)
        cq.multiselect(
            root.get<Long>("id"),
            root.get<String>("firstName"),
            root.get<String>("lastName")
        )
        return entityManager.createQuery(cq).resultList
    }

    fun showClientById(id: Long): ClientDto =
        clientTransformer.transform(clientRepository.findById(id).orElseThrow())
}

