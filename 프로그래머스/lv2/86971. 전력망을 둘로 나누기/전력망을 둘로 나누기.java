import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            lists.add(new ArrayList<>());
        }
        
        for (int i=0; i<wires.length; i++) {
            lists.get(wires[i][0]).add(wires[i][1]);
            lists.get(wires[i][1]).add(wires[i][0]);
        }
        
        boolean[] visited;
        int answer = n;
        for (int i=0; i<wires.length; i++) {
            visited = new boolean[n+1];
            int temp = bfs(lists, visited, wires[i][0], wires[i][1]);
            temp = Math.abs(n - temp - temp);
            answer = Math.min(answer, temp);
        }
        
        return answer;
    }
    
    private int bfs(List<List<Integer>> lists, boolean[] visited, int n1, int n2) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        visited[n1] = true;
        queue.add(n1);
        
        while (queue.size() != 0) {
            int n = queue.poll();
            visited[n] = true;
            
            for (int i=0; i<lists.get(n).size(); i++) {
                int next = lists.get(n).get(i);
                
                if (visited[next] || next == n2) continue;
                
                queue.add(next);
                count++;
            }
        }
        
        return count;
    }
}