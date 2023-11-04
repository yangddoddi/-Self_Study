class Solution {
    fun solution(arr: Array<IntArray>): IntArray {
        val start = Position(
            x = 0, 
            y = 0)
        
        val end = Position(
            x = arr[0].size - 1,
            y = arr.size - 1
        )
        
        val answer = intArrayOf(0, 0)
        compression(arr, start, end, answer)
        
        return answer
    }
    
    fun compression(
        arr: Array<IntArray>,
        start: Position,
        end: Position,
        answer: IntArray
    ) {
        val n = arr[start.y][start.x]
        
        if (checkIfAllSame(arr, start, end)) {
            when (n) {
                0 -> answer[0] += 1
                1 -> answer[1] += 1
                else -> throw RuntimeException()
            }
            
            return
        }
        
        val mid = Position(
            x = (start.x + end.x) / 2,
            y = (start.y + end.y) / 2
        )    
        
        compression(arr, Position(start.x, start.y), Position(mid.x, mid.y), answer)
        compression(arr, Position(mid.x + 1, start.y), Position(end.x, mid.y), answer)
        compression(arr, Position(start.x, mid.y + 1), Position(mid.x, end.y), answer)
        compression(arr, Position(mid.x + 1, mid.y + 1), Position(end.x, end.y), answer)
    }
    
    fun checkIfAllSame(
        arr: Array<IntArray>,
        start: Position,
        end: Position
    ): Boolean {
        val n = arr[start.y][start.x]
        
        for (i in start.y .. end.y) {
            for (j in start.x .. end.x) {
                if (arr[i][j] != n) return false
            }
        }
        
        return true
    }
    
    data class Position(
        val x: Int,
        val y: Int
    )
}