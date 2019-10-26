package ru.lingstra.oop3

class Heuristic1 {

    fun pack(items: List<Int>): List<Container> {
        val ans: MutableList<Container> = mutableListOf()
        val given = mutableListOf<Int>().apply { addAll(items) }
        while (given.isNotEmpty()) {
            val nextToPlace = given.first()
            given.removeAt(0)
            place(nextToPlace, ans)
        }
        return ans
    }

    private fun place(next: Int, packs: MutableList<Container>) {
        packs.forEach {
            if (it.remainingSize >= next) {
                it.add(next)
                return
            }
        }
        packs.add(Container(next))
    }
}
