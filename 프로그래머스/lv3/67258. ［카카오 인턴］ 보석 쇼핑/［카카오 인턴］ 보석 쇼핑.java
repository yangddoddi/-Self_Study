import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String g : gems) {
            set.add(g);
        }
        
        int target = set.size();
        int idx = 0;
        int left = 0;
        int right = 0;
        int[] answer = new int[2];
        int minDist = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        while (true) {
            if (right < gems.length && map.size() != target) {
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            } else if (map.size() == target) {
                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) { map.remove(gems[left]); }
                left++;
            } else if (right == gems.length) {
                break;
            }
            
            if (map.size() == target && minDist > right-left) {
                minDist = right-left;
                answer = new int[]{left+1, right};
            }
        }

        return answer;
    }
}