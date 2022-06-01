package br.com.itau.card.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Reference
import org.springframework.data.redis.core.RedisHash
import java.time.LocalDate
import java.util.*

@RedisHash("Card")
class Card(
    @Id
    val id: String = UUID.randomUUID().toString(),
    var number: Long? = null,
    val brand: Int,
    var validDate: LocalDate = LocalDate.now(),
    var cvv: Int? = null,
    val nicknameCard: String,
    var holder: Person,
) {
}