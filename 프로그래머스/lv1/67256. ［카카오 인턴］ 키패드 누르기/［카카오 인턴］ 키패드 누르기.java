class Solution {
    public String solution(int[] numbers, String hand) {
        int left = 10;
        int right = 12;
        StringBuilder sb = new StringBuilder();
        
        for (int n : numbers) {
            if ( n == 0 ) { n = 11; }
            
            if ( n%3 == 1 ) {
                left = n;
                sb.append("L");
            }
            
            if ( n%3 == 2 ) {
                if (getPosition(left,right,n).equals("LEFT")) {
                    left = n;
                    sb.append("L");
                }
                else if (getPosition(left,right,n).equals("RIGHT")) {
                    right = n;
                    sb.append("R");
                }
                else {
                    if (hand.equals("left")) {
                        left = n;
                        sb.append("L");
                    } else {
                        right = n;
                        sb.append("R");
                    }
                }
            }
            
            if ( n%3 == 0 ) {
                right = n;
                sb.append("R");
            }
        }
        
        return sb.toString();
    }
    
    public String getPosition(int left, int right, int num) {
        
        int leftX = (left-1)/3;
        int leftY = (left-1)%3;
        
        int rightX = (right-1)/3;
        int rightY = (right-1)%3;
        
        int numX = (num-1)/3;
        int numY = (num-1)%3;
        
        int resultL = Math.abs(leftX-numX) + Math.abs(leftY-numY);
        int resultR = Math.abs(rightX-numX) + Math.abs(rightY-numY);
        
        if (resultL == resultR) return "DRAW";
        
        return (resultL > resultR) ? "RIGHT" : "LEFT";
    }
}