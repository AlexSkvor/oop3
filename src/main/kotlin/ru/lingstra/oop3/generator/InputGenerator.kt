package ru.lingstra.oop3.generator

import java.io.File
import kotlin.random.Random

class InputGenerator {

    companion object {
        fun generate(tests: List<Int>) {
            tests.forEach { generateFile(it) }
        }

        private fun generateFile(size: Int) {
            println(size)
            File("task$size.txtLab").printWriter().use { out ->
                for (i in 0 until size){
                    out.println(Random.nextInt(1, 1000000))
                }
            }
        }
    }
}