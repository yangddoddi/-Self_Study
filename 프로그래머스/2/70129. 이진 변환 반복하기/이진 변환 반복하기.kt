class Solution {
    fun solution(s: String): IntArray {
        var zeroCount = 0
        var convertCount = 0
        var target = s
        
        while (target != "1") {
            val (str, cnt) = convert(target)
            
            zeroCount += cnt
            convertCount += 1
            target = str
        }
        
        return intArrayOf(convertCount, zeroCount)
    }
    
    fun convert(s: String): Pair<String, Int> {
        val zeroCount = s.filter { char -> char == '0' }.count()
        val sWithoutZeroIntegerLength = s.filter { char -> char != '0' }.count()
        
        return sWithoutZeroIntegerLength.toString(2) to zeroCount
    }
}