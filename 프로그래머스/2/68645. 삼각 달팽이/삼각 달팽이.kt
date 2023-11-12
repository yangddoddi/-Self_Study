class Solution {
    fun solution(n: Int): IntArray {
        val triangle = Array(n) { IntArray(n) }
        val maxCount = getMaxCount(n)
        fillTriangle(triangle, maxCount)
        
        val answer = mutableListOf<Int>()
        
        for (i in triangle.indices) {
            for (j in triangle[i].indices) {
                if (triangle[i][j] != 0) answer.add(triangle[i][j])
            }
        }
        
        return answer.toIntArray()
    }
    
    fun fillTriangle(
        array: Array<IntArray>,
        maxCount: Int
    ) {
        var direction = Direction.DOWN
        var currCount = 1
        var idx = Pair(0, 0)
        
        while (currCount <= maxCount) {
            val y = idx.first
            val x = idx.second
            val nextY = y + direction.moveY
            val nextX = x + direction.moveX
            
            array[y][x] = currCount
            
            if (!(nextY in array.indices)
                || !(nextX in array[0].indices)
                || array[nextY][nextX] != 0
            ) {
                direction = direction.nextDirection()
            }
            
            idx = direction.move(idx)
            currCount++
        }
    }
    
    fun getMaxCount(
        n: Int
    ): Int {
        return (n*(n+1))/2
    }
    
    enum class Direction(
        val moveX: Int,
        val moveY: Int
    ) {
        DOWN(0, 1),
        RIGHT(1, 0),
        LEFT_UP(-1, -1);
        
        fun nextDirection(): Direction {
            return when (this) {
                DOWN -> RIGHT
                RIGHT -> LEFT_UP
                LEFT_UP -> DOWN
            }
        }
        
        fun move(
            dir: Pair<Int, Int>
        ): Pair<Int, Int> {
            return Pair(dir.first + this.moveY, dir.second + this.moveX)
        }
    }
}