import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int high = Math.max(arrayA[0], arrayB[0]);
        int low = Math.min(arrayA[0], arrayB[0]);
        
        int answer = 0;
        for (int i=high; i>=2; i--) {
            boolean flagA = false;
            boolean flagB = false;
            
            for (int j=0; j<arrayA.length; j++) {
                int a = arrayA[j] % i;
                int b = arrayB[j] % i;
                
                if (a == 0) flagA = true;
                
                if (b == 0) flagB = true;
                
                if (flagA == true && flagB == true) break;
                
                if (flagA == false && flagB == false) break;
                
                if (flagA == true && a != 0) break;
                
                if (flagB == true && b != 0) break;
                
                if (j == arrayA.length - 1) answer = i;
            }
            
            if (answer != 0) break;
        }
        
        return answer;
    }
}