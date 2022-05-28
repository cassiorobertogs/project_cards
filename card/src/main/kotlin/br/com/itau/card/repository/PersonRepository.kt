package br.com.itau.card.repository

import br.com.itau.card.model.Person
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: CrudRepository <Person, String>{
     
}