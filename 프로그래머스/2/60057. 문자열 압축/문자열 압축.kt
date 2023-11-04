class Solution {
    fun solution(s: String): Int {
        if (s.length == 1) return 1
        
        val list = s.map {
            char -> char.toString()
        }
        
        var answer = Int.MAX_VALUE
        for (i in 1 until s.length) {
            answer = Math.min(compression(list, i), answer)
        }
        
        return answer
    }
    
    fun compression(
        s: List<String>,
        length: Int
    ): Int {
        val tokens = mutableListOf<String>()
        
        for (i in s.indices step length) {
            var tempString = ""
            
            for (j in i until i + length) {
                if (j in s.indices) tempString += s[j]
            }
            
            tokens.add(tempString)
        }
        
        var prev = 0
        var idx = 1
        var word = tokens[0]
        
        while (idx in tokens.indices) {
            if (tokens[prev] == tokens[idx]) {
                var sameNumCount = 2
                
                while (idx + 1 in tokens.indices && tokens[idx+1] == tokens[prev]) {
                    sameNumCount += 1
                    idx += 1
                }
                
                idx += 1
                word += sameNumCount
            } else {
                word += tokens[idx]
                prev = idx
                idx += 1
            }
        }
        
        return word.length
    }
}