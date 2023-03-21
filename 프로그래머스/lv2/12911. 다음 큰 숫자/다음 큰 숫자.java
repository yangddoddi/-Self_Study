class Solution {
    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int countOne = 0;
        
        for (int i=0; i<binary.length(); i++) {
            if (binary.charAt(i) == '1')
                countOne++;
        }
        
        for (int i=n+1; i<Integer.MAX_VALUE; i++) {
            if (isNextLargestNumber(i, countOne))
                return i;
        }
        
        throw new RuntimeException();
    }
    
    private boolean isNextLargestNumber(int decimal, int countOne) {
        int cnt = 0;
        
        while (decimal > 0) {
            int remainder = decimal % 2;
            decimal /= 2;
            
            if (remainder == 1) 
                cnt++;
        }
        
        return cnt == countOne;
    }
}