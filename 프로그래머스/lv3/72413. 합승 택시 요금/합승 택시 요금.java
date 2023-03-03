import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] routes = new int[n+1][n+1];
        initializeRoutes(routes, n);
        addRoutes(routes, fares);
        
        floyd(routes);
        
        int answer = Integer.MAX_VALUE;
        for (int i=1; i<routes.length; i++) {
            if (routes[s][i] != Integer.MAX_VALUE && routes[i][a] != Integer.MAX_VALUE && routes[i][b] != Integer.MAX_VALUE) {
                answer = Math.min(answer, routes[s][i] + routes[i][a] + routes[i][b]);
            }
        }
        
        return answer;
    } 
    
    private void initializeRoutes(int[][] routes, int n) {
        for (int i=1; i<routes.length; i++) {
            for (int j=1; j<routes.length; j++) {
                if (i == j) {
                    routes[i][j] = 0;
                } else {
                    routes[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }
    
    private void addRoutes(int[][] routes, int[][] fares) {
        for (int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int weight = fare[2];
            
            routes[start][end] = weight;
            routes[end][start] = weight;
        }
    }
    
    private void floyd(int[][] routes) {
        for (int k=1; k<routes.length; k++) {
            for (int i=1; i<routes.length; i++) {
                for (int j=1; j<routes.length; j++) {
                    if (routes[i][k] != Integer.MAX_VALUE && routes[k][j] != Integer.MAX_VALUE) {
                        routes[i][j] = Math.min(routes[i][j], routes[i][k] + routes[k][j]);
                    }
                }
            }
        }
    }
}