import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] answer = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (map.getOrDefault(c, null) != null) {
                answer[i] = i - map.get(c);
            } else {
                answer[i] = -1;
            }
            
            map.put(c, i);
        }
        
        return answer;
    }
}