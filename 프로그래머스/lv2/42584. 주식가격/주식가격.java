import java.util.*;

class Solution {
    // prices : 초 단위로 기록된 주식 가격 배열
    
    // 2 <= prices.length <= 100,000
    // 가격이 떨어지지 않은 기간 반환
    
    // 가격이 떨어지다의 기준 = 상대적임 (예, 1->2->1은 2의 기준에서만 떨어진 것)
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i=0; i<prices.length; i++) {
            answer[i] = 0;
            for (int j=i+1; j<prices.length; j++) {
                answer[i]++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }
        }
        
        return answer;
    }
}