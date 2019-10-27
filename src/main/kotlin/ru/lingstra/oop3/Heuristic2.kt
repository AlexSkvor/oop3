package ru.lingstra.oop3

import ru.lingstra.oop3.Container.Companion.MAX_SIZE
import kotlin.collections.ArrayList

class Heuristic2 {

    fun pack(items: List<Int>): List<Container> {
        val ans: MutableList<Container> = ArrayList((items.size * 0.6f).toInt())
        items.forEach {
            if (it > MAX_SIZE / 2) ans.add(Container(it))
            else insert(it, ans)
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
        val searchResult = binarySearch { new.currentSize - it.currentSize }
        val index = indexFromFound(searchResult) + 1
        add(index, new)
    }
}
