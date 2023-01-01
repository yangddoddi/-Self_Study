import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();
        for (String[] c : clothes) {
            map.put(c[1], new ArrayList());
        }
        
        for (String[] c : clothes) {
            map.get(c[1]).add(c[0]);
        }
        
        return map
            .entrySet()
            .stream()
            .map(e -> map.get(e.getKey()).size())
            .reduce(1, (e1, e2) -> e1*(e2+1))
            -1
            ;
    }
}