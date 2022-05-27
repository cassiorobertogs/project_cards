package br.com.itau.card.service

import br.com.itau.card.model.Person
import br.com.itau.card.repository.PersonRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PersonService(
    private val repository: PersonRepository
) {
        fun add(person: Person): Person {
            person.id = UUID.randomUUID().toString()
            return repository.save(person)
        }
    fun list(): List<Person>{
        return repository.findAll().toList()
    }
}