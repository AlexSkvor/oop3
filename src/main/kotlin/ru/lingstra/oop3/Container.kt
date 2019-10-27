package ru.lingstra.oop3

data class Container(
    val items: MutableList<Int>,
    var currentSize: Int
) {

    constructor(firstItem: Int) : this(mutableListOf(firstItem), firstItem)

    companion object {
        const val MAX_SIZE: Int = 1000000
    }

    val remainingSize: Int
        get() = MAX_SIZE - currentSize

    fun add(item: Int) {
        items.add(item)
        currentSize += item
    }

    fun canAdd(item: Int) = currentSize + item <= MAX_SIZE
}
