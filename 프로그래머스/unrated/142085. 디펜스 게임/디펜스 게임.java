import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> queue = new PriorityQueue<>((e1, e2) -> e2-e1);
        int heart = n;
        int ticket = k;
        int answer = 0;
        
        for (int i=0; i<enemy.length; i++) {
            if (heart - enemy[i] < 0 && ticket != 0 && queue.isEmpty()) {
                ticket -= 1;
                answer++;
                continue;
            }
            
            if (heart - enemy[i] < 0 && ticket != 0) {
                heart -= enemy[i];
                
                int temp = 0;
                if (queue.peek() > enemy[i]) {
                    temp = queue.poll();
                    queue.add(enemy[i]);
                } else {
                    temp = enemy[i];
                }
                
                heart += temp;
                ticket-=1;
                answer++;
                continue;
            }
            
            if (heart - enemy[i] < 0) {
                break;
            }
            
            queue.add(enemy[i]);
            heart -= enemy[i];
            answer++;
        }
        
        return answer;
    }
}