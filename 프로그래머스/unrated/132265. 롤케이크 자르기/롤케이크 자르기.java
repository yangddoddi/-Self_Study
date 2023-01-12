import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> old = new HashMap<>();
        Set<Integer> young = new HashSet<>();
        
        for (int t : topping) {
            old.put(t, old.getOrDefault(t, 0) + 1);
        }
        
        int answer = 0;
        for (int t : topping) {
            young.add(t);
            
            if (old.containsKey(t)) {
                old.put(t, old.get(t) - 1);
                if (old.get(t) == 0) old.remove(t);
            }
            
            if (young.size() == old.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}