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
            
            if (convertCount == 10) break
        }
        
        return intArrayOf(convertCount, zeroCount)
    }
    
    fun convert(s: String): Pair<String, Int> {
        val zeroCount = s.filter { char -> char == '0' }.count()
        
        val sWithoutZero = s
            .filter { char -> char != '0' }
            .map { char -> char.toString() }
            .joinToString("")
        
        val sWithoutZeroIntegerLength = sWithoutZero.length
        
        return Pair<String, Int>(Integer.toString(sWithoutZeroIntegerLength, 2), zeroCount)
    }
}