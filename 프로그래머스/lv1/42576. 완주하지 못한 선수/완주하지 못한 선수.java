import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        
        List<String> answers = map.entrySet()
            .stream()
            .map(e -> e.getKey())
            .filter(e -> map.get(e) > 0)
            .collect(Collectors.toList());
        
        return answers.get(0);
    }
}