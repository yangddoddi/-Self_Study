import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a-b);
        int heapSize = 0;
        
        for (String operation : operations) {
            if (operation.startsWith("I")) {
                int num = Integer.parseInt(operation.split(" ")[1]);
                maxHeap.add(num);
                minHeap.add(num);
                heapSize++;
            }
            
            if (operation.equals("D 1")) {
                if (heapSize == 0) continue;
                
                maxHeap.poll();
                heapSize--;
            }
                
            if (operation.equals("D -1")) {
                if (heapSize == 0) continue;
                
                minHeap.poll();
                heapSize--;
            }
            
            if (heapSize == 0 && (minHeap.size() != 0 || maxHeap.size() !=0)) {
                while (minHeap.size() != 0) {
                    minHeap.poll();
                }
                
                while (maxHeap.size() != 0) {
                    maxHeap.poll();
                }
            }
        }
        
        if (heapSize == 0) return new int[]{0, 0};
        
        return new int[]{maxHeap.poll(), minHeap.poll()};
    }
}