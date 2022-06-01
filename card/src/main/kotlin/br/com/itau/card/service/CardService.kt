package br.com.itau.card.service

import br.com.itau.card.model.Card
import br.com.itau.card.repository.CardRepository
import br.com.itau.card.repository.PersonRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.random.Random

@Service
class CardService(
    private val numberGeneratorService: NumberGeneratorService,
    private val cardRepository: CardRepository,
    private val personRepository: PersonRepository
) {

    fun add(card: Card): Card? {

        /*.let {
        if (it.isPresent) {
            it.get()
        } else
            throw Exception("Pessoa não encontrada")
    }*/
        card.number = numberGeneratorService.generate(brand = card.brand)
        card.holder = personRepository.findById(card.holder.id).get()
        card.validDate = LocalDate.now().plusYears(5)
        card.cvv = Random.nextInt(100, 999)

        return cardRepository.save(card)
    }

    fun findByHolderId(holderId: String): List<Card> {
        return cardRepository.findAll().toList().filter {
            it.holder.id == holderId
        }
    }

    fun findByCardId(id: String): Card {
        return cardRepository.findById(id).get()
    }
}