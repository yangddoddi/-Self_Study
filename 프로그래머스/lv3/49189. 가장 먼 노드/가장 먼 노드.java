import java.util.*;

class Solution {
    class Node {
        int vertex;
        int cost;
        
        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        
        public String toString() {
            return "vertex = " + this.vertex + ", cost = " + this.cost;
        }
    }
    
    public int solution(int n, int[][] edge) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            list.add(new ArrayList());
        }
        
        for (int i=0; i<edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        
        int[] distArr = bfs(list, 1);
        
        int max = 0;
        int answer = 0;
        for (int i=0; i<distArr.length; i++) {
            if (max == distArr[i]) {
                answer++;
                continue;
            }
            
            if (max > distArr[i]) {
                continue;
            }
            
            max = Math.max(distArr[i], max);
            answer = 1;
        }
        
        return answer;
    }
    
    private int[] bfs(List<List<Integer>> list, int start) {
        int[] dist = new int[list.size()];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;
        
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            
            for (int i=0; i<list.get(curr.vertex).size(); i++) {
                int next = list.get(curr.vertex).get(i);
                
                if (dist[next] != 0 || next == 1) continue;
                
                queue.add(new Node(next, curr.cost+1));
                dist[next] = curr.cost+1;
            }
        }

        return dist;
    }
}