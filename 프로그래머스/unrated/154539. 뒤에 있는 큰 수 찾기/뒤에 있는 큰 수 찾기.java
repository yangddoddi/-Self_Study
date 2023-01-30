import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }});
        
        int[] answer = new int[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            while (!queue.isEmpty() && queue.peek()[0] < numbers[i]) {
                answer[queue.poll()[1]] = numbers[i];
            }
            
            queue.add(new int[]{numbers[i], i});
        }
            
        while (!queue.isEmpty()) {
            answer[queue.poll()[1]] = -1;
        }
            
        return answer;
    }
}