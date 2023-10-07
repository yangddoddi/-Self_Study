class Solution {
    fun solution(s: String): String {
        return s
            .split(" ")
            .map { str ->
                str.mapIndexed { idx, char ->
                    changeAlphabet(
                        s = char.toString(),
                        idx = idx
                    )
                }.joinToString("")
            }
            .toString()
            .replace(" ", "")
            .replace(",", " ")
            .replace("[", "")
            .replace("]", "")
    }
    
    fun changeAlphabet(
        s: String,
        idx: Int
    ): String {
        val n = idx % 2
        
        if (n == 0) return s.toUpperCase()
        
        return s.toLowerCase()
    }
}