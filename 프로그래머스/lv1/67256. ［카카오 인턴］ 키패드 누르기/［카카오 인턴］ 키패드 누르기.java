class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] keypad = { {0,0}, {0,1}, {0,2},
                          {1,0}, {1,1}, {1,2},
                          {2,0}, {2,1}, {2,2},
                          {3,0}, {3,1}, {3,2} };
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        
        for ( int n : numbers ) {
            if (n==0) n=11;
            if (n%3 == 0) {
                right = n;
                sb.append("R");
            }
            if (n%3 == 1) {
                left = n;
                sb.append("L");
            }
            if (n%3 == 2) {
                int distanceFromLeft = getDistance(keypad[left-1], keypad[n-1]);
                int distanceFromRight = getDistance(keypad[right-1], keypad[n-1]);
                
                if ( distanceFromLeft > distanceFromRight ) {
                    right = n;
                    sb.append("R");
                }
                if ( distanceFromLeft < distanceFromRight ) {
                    left = n;
                    sb.append("L");                
                }
                if ( distanceFromLeft == distanceFromRight ) {
                    if ( hand.equals("right") ) {
                        right = n;
                        sb.append("R");
                    } else {
                        left = n;
                        sb.append("L");
                    }
                }
            }
        }   
        return sb.toString();
    }
    
    public static int getDistance(int[] keypadPos, int[] numPos) {
            int y = Math.abs(keypadPos[0] - numPos[0]);
            int x = Math.abs(keypadPos[1] - numPos[1]);
            
            return x+y;
        }
}