package ru.lingstra.oop3

import java.io.File

class AnswerWriter {

    fun print(ans: List<List<Int>>, size: Int, time: Long) {
        File("answer$size.txtLab").printWriter().use { out ->
            out.println("Time: $time")
            var i = 0
            ans.forEach {
                i++
                out.print("$i ${it.sum()} \t")
                it.forEach { inner -> out.print("$inner ") }
                out.println()
            }
        }
    }
}