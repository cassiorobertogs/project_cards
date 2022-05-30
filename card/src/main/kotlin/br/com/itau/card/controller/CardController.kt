package br.com.itau.card.controller

import br.com.itau.card.dto.CardRequestDTO
import br.com.itau.card.model.Card
import br.com.itau.card.model.Person
import br.com.itau.card.service.CardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/cards")
class CardController(private val service: CardService) {

    @GetMapping("/person/{holderId}")
    fun findByHolderId(@PathVariable holderId: String): List<Card> {
        print(holderId)
        return service.findByHolderId(holderId)
    }

    @GetMapping("/{id}")
    fun findByCardId(@PathVariable id: String): Card {
        return service.findByCardId(id)
    }

    @PostMapping
    fun add(@RequestBody cardRequest: CardRequestDTO): Card? {
        return service.add(cardRequest.toModel())
    }

}