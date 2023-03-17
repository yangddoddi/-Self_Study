import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int peopleCount = n;
        
        // i % n => 몇 번째 사람인지
        int[] answer = null;
        Map<String, Integer> map = new HashMap<>();
        String prevWord = words[0];
        map.put(prevWord, 1);
        for (int i=1; i<words.length; i++) {
            String currentWord = words[i];
            
            if (prevWord.charAt(prevWord.length()-1) != currentWord.charAt(0)) {
                return new int[]{i%n + 1, i/n + 1};
            }
            
            if (map.getOrDefault(words[i], 0) != 0) {
                return new int[]{i%n + 1, i/n + 1};
            }
            
            map.put(words[i], 1);
            prevWord = words[i];
        }
        
        return new int[]{0, 0};
    }
}