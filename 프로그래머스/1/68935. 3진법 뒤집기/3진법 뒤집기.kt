class Solution {
    fun solution(n: Int): Int {
        val baseThreeN = Integer.toString(n, 3)
        val reversedBaseThreeN = baseThreeN.reversed()
        
        return Integer.valueOf(reversedBaseThreeN, 3)
    }
}