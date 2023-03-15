import java.util.*;
import java.util.stream.*;

class Solution {
    private int[] dist;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int nodeA = road[0];
            int nodeB = road[1];
            
            list.get(nodeA).add(nodeB);
            list.get(nodeB).add(nodeA);
        }
        
        dist = new int[n+1];
        dist = dijkstra(list, destination);
        
        int[] answer = new int[sources.length];
        for (int i=0; i<answer.length; i++) {
            answer[i] = (dist[sources[i]] == Integer.MAX_VALUE) ? -1 : dist[sources[i]];
        }
        
        return answer;
    }
    
    private int[] dijkstra(List<List<Integer>> list, int start) {
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        queue.add(new int[]{start, 0});
        
        for (int i=0; i<dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[start] = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentWeight = current[1];
            
            if (dist[currentNode] < currentWeight) continue;
            
            for (int i=0; i<list.get(currentNode).size(); i++) {
                int nextNode = list.get(currentNode).get(i);
                
                if (dist[nextNode] < currentWeight+1) continue;
                
                dist[nextNode] = currentWeight+1;
                queue.add(new int[]{nextNode, currentWeight+1});
            }
        }
        
        return dist;
    }
}