import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        return map.entrySet()
            .stream()
            .map(e -> {
                return e.getValue();
                })
            .reduce(0, (a, b) -> (a+1) * (b+1) - 1);
    }
}