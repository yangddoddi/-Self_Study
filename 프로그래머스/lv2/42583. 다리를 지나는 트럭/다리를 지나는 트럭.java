import java.util.*;

class Solution {
    // bridge_length : 트럭이 동시에 올라갈 수 있는 수 제한
    // weight : 다리가 견딜 수 있는 무게 (완전히 오르지 않은 트럭 무게는 x)
    // truck_weights : 각 트럭의 무게
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
    
        for (int i=0; i<bridge_length; i++) {
            queue.add(0);
        }
        
        int answer = 0;
        int idx = 0;
        int currentWeight = 0;
        while (idx < truck_weights.length) {
            if (queue.size() >= bridge_length) {
                currentWeight -= queue.poll();
            }
            
            if (currentWeight + truck_weights[idx] > weight) {
                queue.add(0);
            }
            
            if (currentWeight + truck_weights[idx] <= weight) {
                queue.add(truck_weights[idx]);
                currentWeight+= truck_weights[idx];
                idx++;
            }
            
            answer++;
        }
        
        return answer + bridge_length;
    }
}