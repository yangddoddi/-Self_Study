import java.util.*;

class Solution {    
    private int[] memo = new int[2001];
    public long solution(int n) {
        return search(n);
    }
    
    public int search(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        return (memo[n] == 0) ? memo[n] = (search(n-2) + search(n-1)) % 1234567 : memo[n];
    }
}