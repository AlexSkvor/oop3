package ru.lingstra.oop3

import ru.lingstra.oop3.Container.Companion.MAX_SIZE

class Heuristic2 {

    fun pack(items: List<Int>): List<Container> {
        if (items.size <= 10000) return Heuristic1().pack(items)
        val ans: MutableList<Container> = mutableListOf()
        val given = mutableListOf<Int>().apply { addAll(items) }

        while (given.isNotEmpty()) {
            val nextToPlace = given.first()
            given.removeAt(0)
            if (nextToPlace > MAX_SIZE / 2) ans.add(Container(nextToPlace))
            else insert(nextToPlace, ans)
        }
        return ans
    }

    private fun indexFromFound(found: Int) =
        if (found >= 0) found else (found + 2) * (-1)

    private fun insert(next: Int, packs: MutableList<Container>) {
        val searchResult = packs.binarySearch { next - it.currentSize }
        val index = indexFromFound(searchResult)
        if (index < 0) packs.insertOrdered(Container(next))
        else {
            if (!packs[index].canAdd(next)) packs.add(Container(next))
            else {
                val container = packs[index]
                packs.removeAt(index)
                container.add(next)
                packs.insertOrdered(container)
            }
        }
    }

    private fun MutableList<Container>.insertOrdered(new: Container) {
        val searchResult = binarySearch { it.remainingSize - new.remainingSize }
        val index = indexFromFound(searchResult) + 1
        add(index, new)
    }
}
