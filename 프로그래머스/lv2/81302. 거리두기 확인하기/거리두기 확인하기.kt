class Solution {
    companion object {
        val moveX = intArrayOf(1, -1, 0, 0)
        val moveY = intArrayOf(0, 0, 1, -1)
    }
    
    fun solution(places: Array<Array<String>>): IntArray {
        return places
            .map { validateDistance(it) }
            .toIntArray()
    }
    
    private fun validateDistance(place: Array<String>): Int {
        val placeMatrix: Array<Array<String>> = place
            .map { str -> str
                    .map { char -> char.toString() }
                    .toTypedArray()
            }
            .toTypedArray()
            
        for (i in 0 until placeMatrix.size) {
            for (j in 0 until placeMatrix[i].size) {
                if (placeMatrix[i][j] != "P") continue
                
                if (bfs(placeMatrix, j, i) == 0) return 0
            }
        }
        
        return 1
    }
    
    private fun bfs(
        placeMatrix: Array<Array<String>>,
        x: Int,
        y: Int
    ): Int {
        val visited = Array(placeMatrix.size) { IntArray(placeMatrix[0].size) }
        val queue = ArrayDeque<Position>()
        queue.add(Position(x, y))
        
        while (!queue.isEmpty()) {
            val currentPosition = queue.removeFirst()
            
            if (visited[currentPosition.y][currentPosition.x] == 2) continue
            
            for (i in 0 until 4) {
                val currentX = currentPosition.x
                val currentY = currentPosition.y
                
                val nextX = currentX + moveX[i]
                val nextY = currentY + moveY[i]
                
                if (!(nextX in 0 until placeMatrix[0].size && nextY in 0 until placeMatrix.size)) {
                    continue
                }
                
                if ((nextX == x && nextY == y) || visited[nextY][nextX] != 0) {
                    continue
                }
                
                if (placeMatrix[nextY][nextX] == "X") {
                    continue
                }
                
                if (placeMatrix[nextY][nextX] == "O") {
                    queue.add(Position(
                        x = nextX,
                        y = nextY
                    ))
                    
                    visited[nextY][nextX] = visited[currentY][currentX] + 1
                    continue
                }
                
                if (placeMatrix[nextY][nextX] == "P") {
                    return 0
                }
            }
        }
        
        return 1
    }
    
    data class Position(
        val x: Int,
        val y: Int
    )
}