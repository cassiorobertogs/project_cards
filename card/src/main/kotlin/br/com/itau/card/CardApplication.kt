package br.com.itau.card

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CardApplication

fun main(args: Array<String>) {
	runApplication<CardApplication>(*args)
}
