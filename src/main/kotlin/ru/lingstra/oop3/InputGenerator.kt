package ru.lingstra.oop3

import java.io.File
import kotlin.random.Random

class InputGenerator {

    fun generate(tests: List<Int>) {
        tests.forEach { generateFile(it) }
    }

    private fun generateFile(size: Int) {
        val list = mutableListOf<Int>()
        for (i in 0 until size) {
            list.add(Random.nextInt(1, 1000000))
        }
        File("task$size.txtLab").printWriter().use { out ->
            list.sortedDescending().forEach {
                out.println(it)
            }
        }
    }
}