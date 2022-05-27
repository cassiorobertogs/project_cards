package br.com.itau.card.repository

import br.com.itau.card.model.Card
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CardRepository : CrudRepository<Card, String> {
    fun findByBrand(brand: Int): List<Card>

    fun findByHolderId(id: String): List<Card>
}
//find by sub propertis spring date