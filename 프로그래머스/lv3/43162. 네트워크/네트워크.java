import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int total = computers.length * computers[0].length;
        
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0; i<total; i++) {
            lists.add(new ArrayList());
        }
        
        for (int i=0; i<computers.length; i++) {
            for (int j=0; j<computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    lists.get(i).add(j);
                    lists.get(j).add(i);
                } 
            }
        }
        
        int answer = 0;
        boolean[] visited = new boolean[total];
        for (int i=0; i<lists.size(); i++) {
            for (int j=0; j<lists.get(i).size(); j++) {
                int node = lists.get(i).get(j);
                
                if (!visited[node]) {
                    answer++;
                    dfs(lists, node, visited);
                }
            }
        }
        
        return answer;
    }
    
    private void dfs(List<List<Integer>> lists, int node, boolean[] visited) {
        if (visited[node]) return;
        visited[node] = true;
        
        for (int i=0; i<lists.get(node).size(); i++) {
            int next = lists.get(node).get(i);
            
            if (!visited[next]) {
                dfs(lists, next, visited);
            }
        }
    }
}