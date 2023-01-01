import java.util.*;

class Solution {
    private boolean flag = false;
    private String[] a;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (e1, e2) -> {
            return e1[1].compareTo(e2[1]);
        });
        
        boolean[] visited = new boolean[tickets.length];
        List<String> answer = new ArrayList<>();
        answer.add("ICN");
        dfs(tickets, visited, answer);
        
        return a;
    }
    
    public void dfs(String[][] tickets, boolean[] visited, List<String> answer) {
        if (answer.size() == tickets.length+1) {
            a = answer.stream().toArray(String[]::new);
            flag = true;
        }
        
        if (flag) return;
        
        for (int i=0; i<tickets.length; i++) {
            String prev = answer.get(answer.size()-1);
            
            if (visited[i]) continue;
            
            if (tickets[i][0].equals(prev)) {
                visited[i] = true;
                answer.add(tickets[i][1]);
                dfs(tickets, visited, answer); 
                answer.remove(answer.size()-1);
                visited[i] = false;
            }
        }
    }
}