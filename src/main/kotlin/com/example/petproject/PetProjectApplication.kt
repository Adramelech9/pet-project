package com.example.petproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
class PetProjectApplication

fun main(args: Array<String>) {
	runApplication<PetProjectApplication>(*args)
}
