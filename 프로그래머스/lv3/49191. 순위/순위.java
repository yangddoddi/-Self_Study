import java.util.*;

class Solution {
    private final int MAX = 10000;
    
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n+1][n+1];
        
        for (int i=0; i<graph.length; i++) {
            for (int j=0; j<graph[i].length; j++) {
                if (i != j) {
                    graph[i][j] = MAX;
                }
            }
        }
        
        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
        }
        
        for (int k=1; k<graph.length; k++) {
            for (int i=1; i<graph.length; i++) {
                for (int j=1; j<graph[i].length; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        
        int answer = n;
        for (int i=1; i<graph.length; i++) {
            for (int j=1; j<graph[i].length; j++) {
                if (i == j) continue;
                
                if (graph[i][j] == MAX && graph[j][i] == MAX) {
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
}