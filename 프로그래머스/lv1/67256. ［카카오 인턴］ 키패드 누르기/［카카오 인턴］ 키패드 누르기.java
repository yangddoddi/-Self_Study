class Solution {
    public String solution(int[] numbers, String hand) {
        int left = 0;
        int tight = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int n : numbers) {
            if ( n%3 == 1 ) {
                left = n;
                sb.append("L");
            }
            if ( n%3 == 2 ) {
                
            }
            if ( n%3 == 0 ) {
                right = n;
                sb.append("R");
            }
        }
    }
}