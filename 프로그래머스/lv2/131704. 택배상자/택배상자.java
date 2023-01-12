import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i=1; i<=order.length; i++) {
            queue.add(i);
        }
        
        int idx = 0;
        int answer = 0;
        while (idx < order.length) {
            int target = order[idx];
            
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                answer++;
                idx++;
                continue;
            }
            
            if (!queue.isEmpty() && queue.peek() == target) {
                queue.poll();
                answer++;
                idx++;
                continue;
            }
            
            if (!queue.isEmpty() && queue.peek() != target) {
                stack.push(queue.poll());
            }
            
            if (queue.isEmpty() && !stack.isEmpty() && stack.peek() != target) {
                return answer;
            }
        }
        
        return answer;
    }
}