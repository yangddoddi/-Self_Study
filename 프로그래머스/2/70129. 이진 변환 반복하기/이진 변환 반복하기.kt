class Solution {
    fun solution(s: String): IntArray {
        return process(s, 0, 0)
    }
    
    fun process(
        s: String,
        deletedZeroCnt: Int,
        convertCnt: Int
    ): IntArray {
        if (s == "1") return intArrayOf(convertCnt, deletedZeroCnt)
        
        var newS = ""
        var zeroCnt = 0
        
        for (i in 0 until s.length) {
            if (s[i] == '0') {
                zeroCnt++
            } else {
                newS += s[i]
            }
        }
        
        val c = Integer.toString(newS.length, 2)
        
        return process(c, deletedZeroCnt + zeroCnt, convertCnt + 1)
    }
}