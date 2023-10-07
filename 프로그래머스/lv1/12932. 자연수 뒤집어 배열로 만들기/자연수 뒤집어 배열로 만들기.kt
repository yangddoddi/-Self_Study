class Solution {
    fun solution(n: Long): IntArray {
        return n.toString()
            .map { Integer.valueOf(it.toString()) }
            .toIntArray()
            .apply {
                this.reverse()
            }
    }
}