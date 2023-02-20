import java.util.*;

class Solution {
    private int[] moveX = new int[]{1,-1,0,0};
    private int[] moveY = new int[]{0,0,1,-1};
    private int[][] dp;
    private int answer;
    private int mod = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m+1][n+1];
        dp = new int[m+1][n+1];
        
        for (int[] p : puddles) {
            map[p[0]][p[1]] = -1;
        }
        
        dp[1][1] = 1;
        for (int i=1; i<map.length; i++) {
            for (int j=1; j<map[i].length; j++) {
                if (map[i][j] == -1) continue;
                if (dp[i-1][j] > 0) dp[i][j] += dp[i-1][j] % mod;
                if (dp[i][j-1] > 0) dp[i][j] += dp[i][j-1] % mod;
            }
        }
        
        return dp[m][n]%mod;
    }
}