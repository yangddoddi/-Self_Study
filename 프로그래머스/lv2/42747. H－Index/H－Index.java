import java.util.*;

class Solution {
// 발표 논문 중 h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었으면 h 최대값이 h-in     
// 1 <= 발표 논문 수 <= 1000
// 0 <= 논문별 인용횟수 <= 10,000
    public int solution(int[] citations) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int citation : citations) {
            queue.add(citation);
        }
        
        int answer = 0;
        int temp = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            if (count > temp) temp = queue.poll();
            
            if (count <= temp && queue.size()+1 >= count) answer = count;
            
            if (count <= temp) count++;
        }
        
        return answer;
    }
}