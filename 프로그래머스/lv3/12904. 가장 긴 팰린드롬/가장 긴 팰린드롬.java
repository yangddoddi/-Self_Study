class Solution
{
    public int solution(String s)
    {    
        boolean[][] dp = new boolean[s.length()][s.length()];
        int answer = 1;
        
        for (int i=0; i<dp.length; i++) {
            dp[i][i] = true;
        }
        
        for (int i=s.length()-1; i>=0; i--) {
            
            for (int j=i+1; j<s.length(); j++) {
                int left = i;
                int right = j;
                
                char leftChar = s.charAt(i);
                char rightChar = s.charAt(j);
                
                if (leftChar != rightChar) continue;
                
                if (right - left < 3) dp[i][j] = true;
                
                if (right - left >= 3) dp[i][j] = (dp[i+1][j-1] == true) ? true : false;
                
                if (dp[i][j] == true) {
                    answer = Math.max(j-i+1, answer);
                }
            }
        }
        
        return answer;
    }
}