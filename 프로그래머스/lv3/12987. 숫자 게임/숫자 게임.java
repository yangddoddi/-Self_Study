import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Queue<Integer> teamA = new PriorityQueue<>((a,b) -> b-a);
        Queue<Integer> teamB = new PriorityQueue<>((a,b) -> b-a);
        
        for (int a : A) {
            teamA.add(a);
        }
        
        for (int b : B) {
            teamB.add(b);
        }
        
        int answer = 0;
        while (!teamA.isEmpty()) {
            int a = teamA.poll();
            int b = teamB.peek();
            
            if (b > a) {
                answer++;
                teamB.poll();
            }
        }
        
        return answer;
    }
}