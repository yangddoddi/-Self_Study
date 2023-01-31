import java.util.*;

class Solution {
    private int answer = Integer.MAX_VALUE;
    
    public int solution(int x, int y, int n) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> next = new HashSet<>();
        set.add(x);
        
        int cnt = 0;
        while (!set.isEmpty()) {
            if (set.contains(y)) {
                return cnt;
            }
            
            next = new HashSet<>();
            cnt++;
            for (Integer s : set) {
                int n1 = s + n;
                int n2 = s * 2;
                int n3 = s * 3;
                
                if (n1 <= y) next.add(n1);
                if (n2 <= y) next.add(n2);
                if (n3 <= y) next.add(n3);
            }
            
            set = next;
        }
        
        return -1;
    }
}