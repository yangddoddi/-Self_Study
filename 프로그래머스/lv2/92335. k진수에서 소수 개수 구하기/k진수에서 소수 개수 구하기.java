import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String binary = convert(n, k);
        
        int answer = 0;
        String[] arr = binary.split("0");
        for (int i=0; i<arr.length; i++) {
            if (arr[i].equals("")) continue;
            
            long num = Long.valueOf(arr[i]);
            
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while (n != 0) {
            int digit = n % k;
            sb.append(digit);
            n /= k;
        }
        
        return sb.reverse().toString();
    }
    
    private boolean isPrime(long n) {
        if (n == 0 || n == 1) return false;
        
        for (int i=2; i<=(int)(Math.sqrt(n)); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}