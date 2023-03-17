class Solution {
    public int solution(int n) {
        return fibonacci(n);
    }
    
    private int[] memoization = new int[100001];
    private int fibonacci(int n) {
        if (n == 0) return 0;
        
        if (n == 1) return 1;
        
        if (memoization[n] != 0) return memoization[n];
        
        return memoization[n] = (fibonacci(n-2) + fibonacci(n-1)) % 1234567;
    }
}