package ru.lingstra.oop3

import java.util.*

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val generator = InputGenerator()
        val reader = Reader()
        val answerWriter = AnswerWriter()
        val task = listOf(10, 100, 1000, 10000, 100000, 200000, 500000, 1000000)

        generator.generate(task)

        val stupid = Heuristic1()
        val clever = Heuristic2()

        task.forEach {
            if (it < 1) {
                val test = reader.read(it)
                val start = Date().time
                val answer = stupid.pack(test)
                val end = Date().time
                answerWriter.print(answer, it, end - start, "BAD")
            }
        }

        task.forEach {
            val test = reader.read(it)
            val start = Date().time
            val answer = clever.pack(test)
            val end = Date().time
            answerWriter.print(answer, it, end - start, "GOOD")
        }
    }
}
