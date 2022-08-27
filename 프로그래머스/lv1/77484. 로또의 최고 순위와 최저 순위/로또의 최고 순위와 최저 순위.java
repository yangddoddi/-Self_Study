import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> lottosList = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        List<Integer> winNumsList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        
        winNumsList.retainAll(lottosList);
        
        int zero_count = 0;
        
        for (int i=0; i<lottosList.size(); i++) {
            if (lottosList.get(i) == 0) zero_count++;
        }
        
        int highScore = 7 - (winNumsList.size() + zero_count);
        int lowScore = 0;
        
        if ( winNumsList.size() == 0 ) { lowScore = 6; }
        if ( winNumsList.size() == 0 && zero_count == 0 ) { highScore = 6; }
        if ( winNumsList.size() != 0 ) { lowScore = 7 - winNumsList.size(); }
        
        return new int[]{highScore, lowScore};
    }
}