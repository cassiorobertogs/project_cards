package br.com.itau.card.service

import br.com.itau.card.model.Card
import br.com.itau.card.model.Person
import br.com.itau.card.repository.CardRepository
import br.com.itau.card.repository.PersonRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.UUID

@Service
class CardService(private val cardRepository: CardRepository, private val personRepository: PersonRepository) {

    fun add(brand: Int, personId: String): Card? {
        val person = personRepository.findById(personId).let {
            if (it.isPresent) {
                it.get()
            } else
                throw Exception("Pessoa não encontrada")
        }


        var card = Card(
            number = 1,
            brand = brand,
            id = UUID.randomUUID().toString(),
            validDate = LocalDate.now().plusYears(5),
            cvv = 111,
            nameCard = "marcia",
            holder = person
        )
        return cardRepository.save(card)
    }

    fun findByHolderId(holderId: String): List<Card> {
        return cardRepository.findAll().toList().filter {
            it.holder?.id == holderId
        }
    }
}