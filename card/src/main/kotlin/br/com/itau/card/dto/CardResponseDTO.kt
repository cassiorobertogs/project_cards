package br.com.itau.card.dto

import java.time.LocalDate

interface CardResponseDTO {
    val number: Long
    val validDate: LocalDate
    val nicknameCard: String
}