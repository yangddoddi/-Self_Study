import java.util.*;

class Solution {
    private int[] parents;
    
    public int solution(int n, int[][] costs) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        initializeQueue(queue, costs);
        initializeParents(n);
        
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] cost = queue.poll();
            
            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                answer += cost[2];
            }
        }
        
        return answer;
    }
    
    private void initializeQueue(Queue<int[]> queue, int[][] costs) {
        for (int[] cost : costs) {
            queue.add(cost);
        }
    }
    
    private void initializeParents(int n) {
        parents = new int[n];
        
        for (int i=0; i<n; i++) {
            parents[i] = i;
        }
    }
    
    private void union(int nodeA, int nodeB) {
        int parentA = find(nodeA);
        int parentB = find(nodeB);
        
        if (parentA < parentB) {
            parents[parentB] = parentA;
        } else {
            parents[parentA] = parentB;
        }
    }
    
    private int find(int node) {
        if (parents[node] == node) return node;
        
        return parents[node] = find(parents[node]);
    }
}