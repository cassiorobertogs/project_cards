package br.com.itau.card.model

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.util.*

@RedisHash
class Person(
    @Id
    var id: String = UUID.randomUUID().toString(),
    val holderName: String? = null,
    val document: String? = null,
) {
}