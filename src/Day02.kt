import kotlin.math.abs

fun main() {

    fun checkGrow(report: ArrayList<Int>) : Boolean {
        val reportSorted = report.toMutableList()
        reportSorted.sort()
        val reportsSortedReversed = reportSorted.toMutableList()
        reportsSortedReversed.reverse()

        return report == reportSorted || report == reportsSortedReversed
    }

    fun checkDifference(report: ArrayList<Int>) : Boolean {
        var maxDiff = 0
        var i = 0
        var equal = false
        do {
            val diff = abs(report[i] - report[i + 1])
            if (diff > maxDiff) maxDiff = diff
            if (diff == 0) equal = true
            i++
        } while (i < report.size - 1)

        return maxDiff in 1..3 && !equal
    }

    fun trimReport(report: ArrayList<Int>, index: Int) : ArrayList<Int> {
        report.removeAt(index)

        return report
    }

    fun part1(input: List<String>): Int {

        val reports: ArrayList<ArrayList<Int>> = arrayListOf()

        for (line in input) {
            val reportString = line.split(" ")
            val reportValues: ArrayList<Int> = arrayListOf()

            for (char in reportString) {
                reportValues.add(char.toInt())
            }

            reports.add(reportValues)
        }

        val possibleSafeReports: ArrayList<ArrayList<Int>> = arrayListOf()

        for (report in reports) {
            val reportSorted = report.toMutableList()
            reportSorted.sort()
            val reportsSortedReversed = reportSorted.toMutableList()
            reportsSortedReversed.reverse()

            if (report == reportSorted || report == reportsSortedReversed) {
                possibleSafeReports.add(report)
            }
        }

        val safeReports: ArrayList<ArrayList<Int>> = arrayListOf()

        for (report in possibleSafeReports) {
            var maxDiff = 0
            var i = 0
            var equal = false
            do {
                val diff = abs(report[i] - report[i+1])
                if (diff > maxDiff) maxDiff = diff
                if (diff == 0) equal = true
                i++
            } while (i < report.size - 1)

            if (maxDiff in 1..3 && !equal) safeReports.add(report)
        }

        return safeReports.count()
    }

    fun part2(input: List<String>): Int {
        val reports: ArrayList<ArrayList<Int>> = arrayListOf()

        for (line in input) {
            val reportString = line.split(" ")
            val reportValues: ArrayList<Int> = arrayListOf()

            for (char in reportString) {
                reportValues.add(char.toInt())
            }

            reports.add(reportValues)
        }

        val safeReports: ArrayList<ArrayList<Int>> = arrayListOf()

        for (report in reports) {

            if (checkGrow(report) && checkDifference(report)) {
                safeReports.add(report)
            } else {
                var i = 0

                while (i < report.size) {
                    var resizedReport = ArrayList(report.toMutableList())
                    resizedReport = trimReport(resizedReport, i)
                    i++

                    if (checkGrow(resizedReport) && checkDifference(resizedReport)) {
                        safeReports.add(resizedReport)
                        break
                    }
                }
            }
        }

        return safeReports.count()
    }



    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    print("Part 1: ")
    part1(input).println()
    print("Part 2: ")
    part2(input).println()
}
