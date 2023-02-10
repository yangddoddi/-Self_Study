import java.util.*;

class Solution {
    private final int MAX_TIME = 60 * 24;
    
    public int solution(String[][] book_time) {
        int[] times = new int[MAX_TIME+11];
        
        for (String[] time : book_time) {
            String[] startTimeArr = time[0].split(":");
            String[] endTimeArr = time[1].split(":");
            
            int startTime = Integer.parseInt(startTimeArr[0]) * 60 + Integer.parseInt(startTimeArr[1]);
            int endTime = Integer.parseInt(endTimeArr[0]) * 60 + Integer.parseInt(endTimeArr[1]) + 9;
            
            for (int i=startTime; i<=endTime; i++) {
                times[i] += 1;
            }
        }
        
        int answer = 0;
        for (int t : times) {
            answer = Math.max(t, answer);
        }
        
        return answer;
    }
}