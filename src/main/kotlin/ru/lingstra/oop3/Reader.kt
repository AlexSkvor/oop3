package ru.lingstra.oop3

import java.io.File

class Reader {

    fun read(size: Int): List<Int> =
        File("task$size.txtLab").readLines().map { it.toInt() }

}