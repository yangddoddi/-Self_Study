class Solution {
    fun solution(s: String): Int {
        if (s.length == 1) return 1
        
        val stringList = s
            .map { char -> char.toString() }
        
        var answer = Int.MAX_VALUE
        for (i in 1 until stringList.size) {
            answer = Math.min(getTotalWordsCount(stringList, i), answer)
        }
        
        return answer
    }
    
    fun getTotalWordsCount(
        stringList: List<String>,
        length: Int
    ): Int {
        val tokens = mutableListOf<String>()
        
        for (i in stringList.indices step length) {
            var tempString = ""
            
            for (j in i until i + length) {
                if (j in stringList.indices) tempString += stringList[j]
            }
            
            tokens.add(tempString)
        }
        
        var idx = 1
        var prev = 0
        var word = tokens[0]

        while (idx in tokens.indices) {            
            if (tokens[idx] == tokens[prev]) {
                var numCount = 2
                
                while (idx + 1 < tokens.size && tokens[idx+1] == tokens[prev]) {
                    idx += 1
                    numCount += 1
                }
                
                idx += 1
                word += numCount
            } else {
                word += tokens[idx]
                prev = idx
                idx += 1
            }
        }
        
        return word.length
    }
}