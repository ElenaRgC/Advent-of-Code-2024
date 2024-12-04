fun main() {
    fun part1(input: List<String>): Int {
        var concatenatedInput = ""

        for (line in input) {
            concatenatedInput += line
        }

        val mulRegex = Regex("mul\\(\\d+,\\d+\\)")
        val muls = mulRegex.findAll(concatenatedInput).map { it.value }.toList()

        val numbers: ArrayList<List<Int>> = arrayListOf()

        for (mul in muls) {
            val pair = Regex("\\d+").findAll(mul).map { it.value.toInt() }.toList()
            numbers.add(pair)
        }

        var result = 0

        for (pair in numbers) {
            result += pair[0] * pair[1]
        }

        return result
    }

    fun part2(input: List<String>): Int {

        var concatenatedInput = ""

        for (line in input) {
            concatenatedInput += line
        }

        val doRegex = Regex("don't\\(\\).*?do\\(\\)")
        val doList = concatenatedInput.split(doRegex)

        var doString = ""

        for (dos in doList) {
            doString += dos
        }
        val removedDont = doString.split(Regex("don't\\(\\)"))[0]

        val mulRegex = Regex("mul\\(\\d+,\\d+\\)")
        val muls = mulRegex.findAll(removedDont).map { it.value }.toList()

        val numbers: ArrayList<List<Int>> = arrayListOf()

        for (mul in muls) {
            val pair = Regex("\\d+").findAll(mul).map { it.value.toInt() }.toList()
            numbers.add(pair)
        }

        var result = 0

        for (pair in numbers) {
            result += pair[0] * pair[1]
        }

        return result
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)
    check(part2(testInput) == 48)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println() // 6285677 < 7860970 < answer = 127092535 < 129570943
}
