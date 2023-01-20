import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        for (int q : queue1) {
            q1.add(q);
            sum1+=q;
        }
        
        for (int q : queue2) {
            q2.add(q);
            sum2+=q;
        }
        
        int answer = 0;
        while (sum1 != sum2) {
            if (answer > queue1.length * 4) return -1;
            
            if (sum1 > sum2) {
                int n = q1.poll();
                
                sum1-=(long)n;
                sum2+=(long)n;
                q2.add(n);
                answer++;
            }
            
            if (sum2 > sum1) {
                int n = q2.poll();
                
                sum2-=(long)n;
                sum1+=(long)n;
                q1.add(n);
                answer++;
            }
        }
        
        return (sum1 != sum2) ? -1 : answer;
    }
}