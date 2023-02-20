import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        for (int[] route : routes) {
            queue.add(route);
        }
        
        int answer = 0;
        int temp = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int[] route = queue.poll();
            
            if (route[0] > temp) {
                temp = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}