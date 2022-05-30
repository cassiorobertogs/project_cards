package br.com.itau.card.dto

import br.com.itau.card.model.Card
import br.com.itau.card.model.Person

class CardRequestDTO(
    val brand: Int,
    val nicknameCard: String,
    val personId: String,
) {
fun toModel(): Card{
    return Card(brand = brand, nicknameCard = nicknameCard, holder = Person(id = personId))
}
}