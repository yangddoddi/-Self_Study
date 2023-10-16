class Solution {
    var zeroCount = 0
    var oneCount = 0

    fun solution(arr: Array<IntArray>): IntArray {
        recursion(
            arr = arr,
            start = Position(x = 0, y = 0),
            end = Position(x = arr[0].size - 1, y = arr.size - 1)
        )

        return intArrayOf(zeroCount, oneCount)
    }

    fun recursion(
        arr: Array<IntArray>,
        start: Position,
        end: Position
    ) {
        val result = isUniform(
            arr = arr, 
            start = start, 
            end = end
        )

        when (result) {
            0 -> zeroCount++
            1 -> oneCount++
            else -> {
                val midX = (start.x + end.x) / 2
                val midY = (start.y + end.y) / 2

                recursion(
                    arr = arr,
                    start = Position(x = start.x, y = start.y),
                    end = Position(x = midX, y = midY)
                )

                recursion(
                    arr = arr,
                    start = Position(x = midX + 1, y = midY + 1),
                    end = Position(x = end.x, y = end.y)
                )

                recursion(
                    arr = arr,
                    start = Position(x = midX + 1, y = start.y),
                    end = Position(x = end.x, y = midY)
                )

                recursion(
                    arr = arr,
                    start = Position(x = start.x, y = midY + 1),
                    end = Position(x = midX, y = end.y)
                )
            }
        }
    }

    fun isUniform(
        arr: Array<IntArray>,
        start: Position,
        end: Position
    ): Int? {
        val firstNum = arr[start.y][start.x]

        for (i in start.y .. end.y) {
            for (j in start.x .. end.x) {
                if (arr[i][j] != firstNum) return null
            }
        }

        return firstNum
    }

    data class Position(
        val x: Int,
        val y: Int
    )
}