class Solution {
    fun solution(n: Int): IntArray {
        val array = Array(n) { IntArray (n) }
        
        var currentNumber = 1
        var y = 0
        var x = 0
        val limit = n - 1
        
        while (true) {
            array[y][x] = currentNumber++
            
            if ((x+1 > y || array[y][x+1] != 0) && y-1 >= 0 && x-1 >= 0 && array[y-1][x-1] == 0) {
                x--
                y--
                continue
            }
            
            if (y+1 <= limit && array[y+1][x] == 0) {
                y++
                continue
            }
            
            if (x+1 <= limit && x+1 <= y && array[y][x+1] == 0) {
                x++
                continue
            }
            
            break
        }
        
        val answer = run {
            val result = ArrayList<Int>()
            
            for (i in array.indices) {
                for (j in array[i].indices) {
                    if (array[i][j] != 0) {
                        result.add(array[i][j])
                    }
                }
            }
            
            result
        }
        
        return answer.toIntArray()
    }
}