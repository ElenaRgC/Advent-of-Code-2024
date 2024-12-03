import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {

        val firstList: ArrayList<Int> = arrayListOf()
        val secondList: ArrayList<Int> = arrayListOf()

        for (pair in input) {
            val values = pair.split("   ")
            firstList.add(values[0].toInt())
            secondList.add(values[1].toInt())
        }

        firstList.sort()
        secondList.sort()

        val distances: ArrayList<Int> = arrayListOf()

        var i = 0

        do {
            distances.add(abs(firstList[i] - secondList[i]))
            i++
        } while (i < firstList.size)

        return distances.sum()
    }

    fun part2(input: List<String>): Int {

        val firstList: ArrayList<Int> = arrayListOf()
        val secondList: ArrayList<Int> = arrayListOf()

        for (pair in input) {
            val values = pair.split("   ")
            firstList.add(values[0].toInt())
            secondList.add(values[1].toInt())
        }

        val score: ArrayList<Int> = arrayListOf()

        for (element in firstList) {
            if (secondList.contains(element)) {
                val times = secondList.count{ it == element}
                score.add(element * times)
            }
        }

        return score.sum()
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    print("Part 1: ")
    part1(input).println()
    print("Part 2: ")
    part2(input).println()
}
