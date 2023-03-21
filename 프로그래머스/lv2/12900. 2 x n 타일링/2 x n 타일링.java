class Solution {
    public int solution(int n) {
        return fibonacci(n) % 1_000_000_007;
    }
    
    private int[] arr = new int[60001];
    private int fibonacci(int n) {
        if (n == 0) return 1;
        
        if (n == 1) return 1;
        
        if (arr[n] != 0) return arr[n];
        
        return arr[n] = (fibonacci(n-1) + fibonacci(n-2)) % 1_000_000_007;
    }
}