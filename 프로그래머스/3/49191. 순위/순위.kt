class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        val distance = Array(n + 1) { IntArray(n + 1) }
        
        for (i in 1 .. n) {
            for (j in 1 .. n) {
                if (i == j) {
                    distance[i][j] = 0
                } else {
                    distance[i][j] = Int.MAX_VALUE
                }
            }
        }
        
        for (i in results.indices) {
            val humanA = results[i][0]
            val humanB = results[i][1]
            
            distance[humanA][humanB] = 1
            // distance[humanB][humanA] = 1
        }
        
        for (k in 1 until distance.size) {
            for (i in 1 until distance.size) {
                for (j in 1 until distance.size) {
                    if (distance[i][k] == Int.MAX_VALUE || distance[k][j] == Int.MAX_VALUE) continue
                    
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j])
                }
            }
        }
        
        var answer = 0
        for (i in 1 until distance.size) {
            var isAllCheck = true
            
            for (j in 1 until distance[i].size) {
                if (distance[i][j] == Int.MAX_VALUE && distance[j][i] == Int.MAX_VALUE) isAllCheck = false
            }
            
            if (isAllCheck) answer ++
        }
        
        return answer
    }
}