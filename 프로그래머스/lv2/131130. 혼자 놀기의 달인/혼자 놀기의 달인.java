import java.util.*;

class Solution {
    private boolean[] visited;
    private List<Integer> scoreList = new ArrayList<>();
    
    public int solution(int[] cards) {
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i=0; i<=cards.length; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i=0; i<cards.length; i++) {
            list.get(i+1).add(cards[i]);
        }
        
        int num = 0;
        visited = new boolean[cards.length+1];
        for (int i=1; i<list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(list, i, 1, num++);
            }
        }
        
        if (scoreList.size() == 1) return 0;
        
        int max1 = 0;
        int max2 = 0;
        
        for (int n : scoreList) {
            if (Math.max(max1, n) == n) {
                max2 = max1;
                max1 = n;
            } else if (Math.max(max2, n) == n) {
                max2 = n;
            }
        }
        
        return max1 * max2;
    }
    
    private void dfs(List<List<Integer>> list, int node, int count, int num) {
        if ( scoreList.size() - 1 == num && scoreList.get(num) < count ) {
            scoreList.set(num, count);
        }
        
        if ( scoreList.size() - 1 < num) {
            scoreList.add(count);
        }
        
        int nextNode = list.get(node).get(0);
            
        if (!visited[nextNode]) {
            visited[nextNode] = true;
            dfs(list, nextNode, count+1, num);
        }
    }
}
