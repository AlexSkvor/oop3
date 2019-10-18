package ru.lingstra.oop3

import java.util.*

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val generator = InputGenerator()
        val reader = Reader()
        val stupid = Heuristic1()
        val answerWriter = AnswerWriter()
        val task = listOf(10, 100, 1000, 10000, 100000/*, 1000000*/)
        generator.generate(task)
        task.forEach {
            val test = reader.read(it).reversed()
            val start = Date().time
            val answer = stupid.pack(test)
            val end = Date().time
            answerWriter.print(answer, it, end - start)
        }
    }
}