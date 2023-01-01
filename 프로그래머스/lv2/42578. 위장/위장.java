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
        
        int values = map
            .entrySet()
            .stream()
            .map(e -> map.get(e.getKey()).size())
            .reduce(0, (e1, e2) -> e1+e2);
        
        long keys = map
            .entrySet()
            .stream()
            .map(e -> e.getKey())
            .count();
        
        int sum = map
            .entrySet()
            .stream()
            .map(e -> map.get(e.getKey()).size())
            .reduce(1, (e1, e2) -> e1*e2);
        
        System.out.println(values);
        System.out.println(sum);
        
        return (keys == 1L) ? values : values + sum;
    }
}