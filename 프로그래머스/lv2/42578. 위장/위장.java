import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i=0; i < clothes.length; i++) {
            String category = clothes[i][1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        
        return map.entrySet()
            .stream()
            .map(e -> e.getValue())
            .reduce(1, (a, b) -> (a) * (b+1)) - 1;
    }
}