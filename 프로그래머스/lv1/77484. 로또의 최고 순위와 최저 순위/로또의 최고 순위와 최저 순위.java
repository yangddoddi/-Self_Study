import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 1~6등
        // 알아볼 수 없는 번호 0
        // 순서 상관 x
        // 0 이상 45 이하
        // 정렬 x
        // lottos는 0은 중복 가능 , win nums는 중복 x
        
        // lottos와 win nums의 번호를 비교한다(순서 상관 없이)
        // 맞는 번호 개수 0개수가 최고 등수
        // 맞는 번호 개수가 최저 등수
        
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