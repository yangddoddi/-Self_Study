class Solution {
    fun solution(s: String): Boolean {
        return validate(s)
    }
    
    fun validate(s: String): Boolean {
        if (s.length != 4 && s.length != 6) return false
        
        for (i in 0 until s.length) {
            if (s[i] < '0' || s[i] > '9') {
                return false
            }
        }
        
        return true
    }
}