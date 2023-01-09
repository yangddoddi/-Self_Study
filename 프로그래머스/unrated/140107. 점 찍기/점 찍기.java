import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        // boolean checked = new boolean[d*10+1];
        
        for (int i=0; i<=d; i+=k) {
            long n1 = (long)i;
            long n2 = 0;
            long dl = (long)d*(long)d;
            
            n2 = (long)(Math.sqrt(dl - n1*n1));
            answer += (long)n2 /k + 1;
            
        }
        
        return answer;
    }
}