package ru.lingstra.oop3

import ru.lingstra.oop3.generator.InputGenerator

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val task = listOf(10, 100, 1000, 10000, 100000, 1000000)
        InputGenerator.generate(task)
        //while(true)println("AAAAAAAA")
    }
}