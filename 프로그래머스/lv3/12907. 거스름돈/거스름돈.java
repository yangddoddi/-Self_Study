class Solution {
    public int solution(int n, int[] money) {
        
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        
        for (int curr : money) {
            for (int i = curr; i<=n; i ++) {
                dp[i] = dp[i] + dp[i-curr];
            }
        }
        
        return dp[n];
    }
}