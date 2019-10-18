package ru.lingstra.oop3

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val generator = InputGenerator()
        val reader = Reader()
        val stupid = Heuristic1()
        val answerWriter = AnswerWriter()
        val task = listOf(10, 100, 1000, 10000/*, 100000, 1000000*/)
        //generator.generate(task)

        val test = reader.read(10).reversed()
        val answer = stupid.pack(test)
        answerWriter.print(answer, 10)
    }
}