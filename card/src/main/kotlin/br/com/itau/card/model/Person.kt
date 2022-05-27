package br.com.itau.card.model

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash
class Person(
    @Id
    var id: String?,
    val name: String,
    val document: Long,
    ) {
}