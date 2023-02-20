import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int num = s / n;
        
        if (num < 1) return new int[]{-1};
        
        int t = 0;
        if (num * n < s) {
            t += s - (num * n);
        }
        
        int[] answer = new int[n];
        Arrays.fill(answer, num);
        
        for (int i=answer.length-1; i>answer.length-1-t; i--) {
            answer[i]++;
        }
        
        return answer;
    }
}