import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>((e1, e2) -> e1 - e2);
        
        for (int s : scoville) {
            queue.add(s);
        }
        
        int answer = 0;
        while (queue.peek() < K) {
            int food = queue.poll();
            
            if (food < K) {
                if (queue.isEmpty()) return -1;
                
                int food2 = queue.poll();
                queue.add(food + (food2 * 2));
                answer++;
            } 
        }
        
        return answer;
    }
}