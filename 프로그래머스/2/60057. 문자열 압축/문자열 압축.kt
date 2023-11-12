class Solution {
    fun solution(s: String): Int {
        if (s.length == 1) return 1
        
        val stringList = s
            .map { it.toString() }
            .toMutableList()
        
        var answer = Int.MAX_VALUE
        for (i in 1 until stringList.size) {
            answer = Math.min(compressionAndGetLength(
                stringList,
                i
            ), answer)
        }
        
        return answer
    }
    
    fun compressionAndGetLength(
        stringList: MutableList<String>,
        length: Int
    ): Int {
        val words = mutableListOf<String>()
        
        for (i in stringList.indices step length) {
            var word = ""
            
            for (j in i until i+length) {
                if (j in stringList.indices) {
                    word += stringList[j]
                }
            }
            
            words.add(word)
        }
        
        var prevWord = words[0]
        var idx = 1
        var result = words[0]
        
        while (idx in words.indices) {
            if (words[idx] == prevWord) {
                var numCount = 2
                
                while (idx + 1 in words.indices && words[idx + 1] == prevWord) {
                    idx++
                    numCount++
                }
                result += numCount
            } else {
                result += words[idx]
                prevWord = words[idx]
            }
            
            idx++
        }

        return result.length
    }
}