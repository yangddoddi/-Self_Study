import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int storey) {
        String storeyStr = String.valueOf(storey);
        List<Integer> list = Arrays.stream(storeyStr.split(""))
            .map(e -> Integer.valueOf(e))
            .collect(Collectors.toList());
        
        return getAnswer(list);
    }
    
    public int getAnswer(List<Integer> list) {
        int answer = 0;
        
        for (int i=list.size()-1; i>=0; i--) {
            int n = list.get(i);
            
            if (n < 5) {
                answer += n;
                continue;
            }
            
            if (n > 5) {                
                if (i != 0) {
                    list.set(i-1, list.get(i-1)+1);
                    answer += 10 - n;
                }
                
                if (i == 0) {
                    answer += 10 - n + 1;
                }
                
                continue;
            }
            
            if (n == 5) {
                if (i == 0) {
                    answer+=5;
                    continue;
                }
                
                if (list.get(i-1) >= 5) {
                    list.set(i-1, list.get(i-1)+1);
                    answer+=5;
                    continue;
                }
                
                answer += 5;
            }
        }
        
        return answer;
    }
}