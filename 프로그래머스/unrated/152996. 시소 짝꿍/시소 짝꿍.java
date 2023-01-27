import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        long answer = 0L;
        long temp = 0L;
        for (int i=0; i<weights.length; i++) {
            if (i != 0 && weights[i] == weights[i-1]) {
                temp--;
                answer += temp;
                continue;
            }
            
            int n = binarySearch(weights, i);
            temp = 0;
            for (int j=n; j>i; j--) {
                if (weights[i] == weights[j] || weights[j]*2 == weights[i]*3 || weights[j]*2 == weights[i]*4 || weights[j]*3 == weights[i]*4) {
                    temp++;
                }
            }
            answer += temp;
        }
        
        return answer;
    }
    
    private int binarySearch(int[] weights, int idx) {
        int l = idx;
        int r = weights.length-1;
        
        while (l < r) {
            int m = (l+r)/2;
            
            if (weights[m] > weights[idx] * 2) {
                return m;
            }
            
            if (weights[m] <= weights[idx] * 2) {
                l++;
            }
        }
        
        return l;
    }
}