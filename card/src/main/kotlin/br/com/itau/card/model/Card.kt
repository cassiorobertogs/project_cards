package br.com.itau.card.model

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.time.LocalDate

@RedisHash("Card")
class Card(
    @Id
    val id: String,
    val number: Long,
    val brand: Int,
    val validDate: LocalDate,
    val cvv: Int,
    val nicknameCard: String,
    val holder: Person?,
) {
}