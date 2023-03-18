import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // LRU = 가장 오래 사용되지 않은 데이터를 삭제함
        // cache hit인 경우 1
        // cache miss인 경우 5
        
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;
        
        for (int i=0; i<cities.length; i++) {
            if (map.getOrDefault(cities[i].toLowerCase(), -1) == -1) {
                answer += 5;
            } else {
                answer += 1;
            }
            
            map.put(cities[i].toLowerCase(), i);
            
            if (map.size() > cacheSize) {
                String key = map.entrySet()
                    .stream()
                    .sorted((a, b) -> a.getValue() - b.getValue())
                    .findFirst()
                    .get()
                    .getKey();
                
                map.remove(key);
            }
        }
        
        return answer;
    }
}