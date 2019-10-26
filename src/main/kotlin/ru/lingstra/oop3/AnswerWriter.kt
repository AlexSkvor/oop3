package ru.lingstra.oop3

import java.io.File

class AnswerWriter {

    fun print(ans: List<Container>, size: Int, time: Long, addition: String) {
        File("answer$addition$size.txtLab").printWriter().use { out ->
            out.println("Time: $time")
            var i = 0
            ans.forEach {
                i++
                out.print("$i \t\t${it.currentSize}\t\t")
                it.items.forEach { item -> out.print("$item _ ") }
                out.println()
            }
        }
    }
}
