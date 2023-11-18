class Solution {
    var answer = 0
    
    fun solution(numbers: IntArray, target: Int): Int {
        dfs(numbers, target, 0, 0, 0)
        
        return answer
    }
    
    fun dfs(
        numbers: IntArray,
        target: Int,
        count: Int,
        current: Int,
        idx: Int
    ) {
        if (count == numbers.size) {
            if (target == current) {
                answer++
            }
            
            return
        }
        
        val nextA = current + numbers[idx]
        val nextB = current - numbers[idx]
        
        dfs(numbers, target, count + 1, nextA, idx + 1)
        dfs(numbers, target, count + 1, nextB, idx + 1)
    }
}