class Solution {
    fun solution(word: String): Int {
        val dictionary = mutableSetOf<String>()
        val alphabetList = listOf("A", "E", "I", "O", "U")
        
        fillDictionary(dictionary, alphabetList, word, "")
        
        return dictionary.size
    }
    
    fun fillDictionary(
        dictionary: MutableSet<String>,
        alphabetList: List<String>,
        target: String,
        current: String
    ) { 
        if (dictionary.contains(target)) return
        
        if (current.length == 5) return
        
        for (i in alphabetList.indices) {
            if (dictionary.contains(target)) break
            
            val next = current + alphabetList[i]
            
            dictionary.add(next)
            
            fillDictionary(
                dictionary,
                alphabetList,
                target,
                next
            )
        }
    }
}