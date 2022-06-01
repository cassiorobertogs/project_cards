package br.com.itau.card.service

import org.springframework.stereotype.Service
import java.util.*

@Service
class NumberGeneratorService() {
    fun generate(brand: Int): Long {
        val rand = Random()
        var numVerify: Int? = null
        var convertingNum: StringBuilder = StringBuilder()
        var ind: Int = when (brand) {
            1 -> 13
            else -> 16
        }
        var cardNumber = IntArray(ind)

        while (numVerify != 0) {
            var soma1: Int = 0
            var soma2: Int = 0
            var numbers = IntArray(ind)
            var primaryDigits: Int = if (brand == 1) 4 else 5


            for (i in numbers.indices) {
                numbers[i] = rand.nextInt(10)
                numbers[0] = primaryDigits
                if (brand == 2) {
                    numbers[1] = rand.nextInt(6) + 1
                }
                cardNumber[i] = numbers[i]
                println("--Index: ${i}: ${numbers.get(i)}--")
            }
            //temp = numbers
            println()
            for (i in ind - 1 downTo 0 step 2) {
                soma1 += numbers[i]
                println("Index: ${i}: ${numbers.get(i)}")
            }

            println()

            for (i in ind - 2 downTo 0 step 2) {
                numbers[i] = numbers[i] * 2
            }

            for (i in numbers.indices) {
                println("Depois Index: ${i}: ${numbers.get(i)}--")
            }
            println()

            for (i in ind - 2 downTo 0 step 2) {
                if (numbers[i] > 9) {
                    var convertNunToStr = Integer.toString(numbers[i])
                    var numToArr = convertNunToStr.toCharArray()
                    println("Convertendo o numero: ${convertNunToStr} no índice ${i}")
                    println("Ar 1: ${numToArr[0]}")
                    println("Ar 2: ${numToArr[1]}")
                    var convertedNum =
                        Integer.parseInt(numToArr[0].toString()) + Integer.parseInt(numToArr[1].toString())
                    println("Logo ${numbers.get(i)} no indice $i")
                    numbers[i] = convertedNum
                    println("foi convertido para: ${convertedNum}")
                    println()
                }
            }

            for (i in ind - 2 downTo 0 step 2) {
                soma2 += numbers[i]
                println("Resultado dos impares: Index: ${i}: ${numbers.get(i)}--")
            }

            var somaFinal: Int = soma1 + soma2

            println("Resultado s1: ${soma1}")
            println("Resultado s2: ${soma2}")
            println("Resultado s1 + s2: (${somaFinal})")

            numVerify = somaFinal % 10

            println("O dígito verificador: ${numVerify}")

            println()

            for (i in numbers.indices) {
                println("Tratado: ${i} = ${numbers.get(i)}--")
                println("Original: ${i} = ${cardNumber.get(i)}**")
                println()

            }

        }//fim do primeiro loop

        for (i in cardNumber.indices) {
            convertingNum.append(cardNumber[i])
            println("finalizado: ${i} = ${cardNumber.get(i)}**")
        }
        println("teste $convertingNum")
        return convertingNum.toString().toLong()
    }
}