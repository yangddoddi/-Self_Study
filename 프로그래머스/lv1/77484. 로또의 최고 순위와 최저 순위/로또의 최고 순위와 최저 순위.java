import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int zero_count = 0;
        int same_count = 0;
        
        for (int lotto : lottos) {
            if ( lotto == 0 ) zero_count++;
            
            for (int win_num : win_nums) {
                if (win_num == lotto) same_count++;
            }
        }
        
        int sum = zero_count+same_count;
        
        int high_score = 7 - (same_count+zero_count);
        int low_score = 7 - same_count;
        
        if (high_score < 1) high_score = 1; 
        if (high_score > 6) high_score = 6;
        if (low_score > 6) low_score = 6;
        
        return new int[]{high_score, low_score};
    }
}