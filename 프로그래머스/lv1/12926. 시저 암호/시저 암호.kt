class Solution {
    fun solution(s: String, n: Int): String {
        return s.map {
            changeAlphabet(it, n).toString()
        }.joinToString("")
    }
    
    fun changeAlphabet(
        char: Char,
        count: Int
    ): Char {
        if (char == ' ') return char
        
        if (count == 0) return char
        
        return when(char) {
            'z' -> changeAlphabet('a', count - 1)
            'Z' -> changeAlphabet('A', count - 1)
            else -> changeAlphabet(char + 1, count -1)
        }
    }
}