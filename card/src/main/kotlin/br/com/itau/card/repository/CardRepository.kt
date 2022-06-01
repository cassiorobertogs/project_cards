package br.com.itau.card.repository

import br.com.itau.card.dto.CardResponseDTO
import br.com.itau.card.model.Card
import org.springframework.data.annotation.Id
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CardRepository : CrudRepository<Card, String> {

    fun findByHolderId(id: String): List<Card>

    fun findByCardId(id: String): Card


}
//fun findByBrand(brand: Int): List<Card>