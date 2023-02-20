import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        
        for (int w : works) {
            queue.add(w);
        }
        
        for (int i=0; i<n; i++) {
            if (!queue.isEmpty()) {
                int w = queue.poll() - 1;
                if (w > 0) queue.add(w);
            }
        }
        
        long answer = 0;
        while (!queue.isEmpty()) {
            int w = queue.poll();
            answer += (long)(w * w);
        }
        
        return answer;
    }
}