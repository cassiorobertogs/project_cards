package br.com.itau.card.controller

import br.com.itau.card.model.Person
import br.com.itau.card.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/people")
class PersonController(private val service: PersonService) {

    @PostMapping
    fun add(@RequestBody person: Person): Person {
        return service.add(person)
    }

    @GetMapping
    fun list(): List<Person>{
        return service.list()
    }
}