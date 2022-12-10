import java.util.*;

class Solution {
    // progresses = 먼저 배포되어야하는 순서대로 작업 진도 적힌 배열
    // speeds = 각 작업의 개발 속도
    // 각 배포마다 몇 개의 기능이 배포되는지 return
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i=progresses.length-1; i >= 0; i--) {
            stack.push(progresses[i]);
        }
        
        int day = 0;
        int idx = 0;
        int combo = 0;
        List<Integer> answer = new ArrayList<>();
        while (!stack.isEmpty()) {
            day++;
            while (!stack.isEmpty() && stack.peek() + (speeds[idx] * day) >= 100) {
                stack.pop();
                idx+=1;
                combo+=1;
            }
            
            if (combo != 0) {
                answer.add(combo);
                combo = 0;
            }
        }
        
        return answer.stream().mapToInt(e -> e).toArray();
    }
}