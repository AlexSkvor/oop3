package ru.lingstra.oop3

class Heuristic1() {

    fun pack(items: List<Int>, containerSize: Int = 1000000): List<List<Int>> {
        val ans: MutableList<MutableList<Int>> = mutableListOf<MutableList<Int>>()
        val given = mutableListOf<Int>().apply { addAll(items) }
        while (given.isNotEmpty()) {
            val nextToPlace = given.first()
            given.removeAt(0)
            place(nextToPlace, ans, containerSize)
        }
        return ans
    }

    private fun place(next: Int, packs: MutableList<MutableList<Int>>, containerSize: Int) {
        packs.forEach {
            if (it.sum() + next < containerSize) {
                it.add(next)
                return
            }
        }
        packs.add(mutableListOf(next))
    }
}