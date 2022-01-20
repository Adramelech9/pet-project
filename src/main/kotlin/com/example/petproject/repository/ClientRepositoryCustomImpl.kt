package com.example.petproject.repository

import com.example.petproject.model.Client
import com.example.petproject.model.dto.ShortClientDto
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaBuilder

class ClientRepositoryCustomImpl : ClientRepositoryCustom {

    @Autowired
    private lateinit var entityManager: EntityManager

    override fun findShortClients(): List<ShortClientDto> {
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
}
