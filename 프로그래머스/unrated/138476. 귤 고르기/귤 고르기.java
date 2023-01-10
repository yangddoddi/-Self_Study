import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : tangerine) {
            int prev = map.getOrDefault(i, 0);
            map.put(i, prev+1);
        }
        
        List<Integer> list = map.entrySet()
            .stream()
            .map(e -> e.getValue())
            .sorted((e1, e2) -> e2 - e1)
            .collect(Collectors.toList());
        
        int answer = 0;
        int sum = 0;
        for (Integer l : list) {
            sum += l;
            answer ++;
            
            if (sum >= k) break;
        }
        
        
        return answer;
    }
}