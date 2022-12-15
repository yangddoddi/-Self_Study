import java.util.*;

class Solution {
    // 스코빌 지수가 가장 낮은 두 개의 음식을 섞음
    // 섞을 스코빌 지수 = 가장 맵지 않은 스코빌 + (두 번째로 맵지 않은 스코빌 *2)
    // K => 모든 음식 스코빌 지수가 K 이상이여야 함
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int s : scoville) {
            queue.add(s);
        }
        
        while (queue.size() > 1) {
            int min = queue.poll();
            int next = queue.poll();
            
            int comb = min + (next * 2);
            queue.add(comb);
            answer++;
            
            if (queue.peek() > K) return answer;
        }
        
        return -1;
    }
}