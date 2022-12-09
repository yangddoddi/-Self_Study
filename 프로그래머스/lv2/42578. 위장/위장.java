import java.util.*;

class Solution {
    // 2차원배열 [0] = 이름
    // 2차원배열 [1] = 타입
    
    // 아무것도 입지 않는 경우의 수는 없다.
    // m과 n의 경우의 수 구하는 방법 = m * n
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int result = map.entrySet()
            .stream()
            .mapToInt(e -> e.getValue()+1)
            .reduce(1, (a,b) -> a*b);
        
        return result -1 ;
    }
}