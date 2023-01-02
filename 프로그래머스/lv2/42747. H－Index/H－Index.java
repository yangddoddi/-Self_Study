import java.util.*;

class Solution {
    // 논문 n편 중 h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다?
    // h 최대값이 H-Index
    public int solution(int[] citations) {
        Queue<Integer> queue = new PriorityQueue<>((e1,e2) -> e1 - e2);
        
        for (int c : citations) {
            queue.add(c);
        }
        
        int answer = 0;
        while (!queue.isEmpty()) {
            while (queue.peek() >= answer && queue.size() >= answer) {
                answer++;
            }
            
            queue.poll();
        }
        
        return answer-1;
    }
}