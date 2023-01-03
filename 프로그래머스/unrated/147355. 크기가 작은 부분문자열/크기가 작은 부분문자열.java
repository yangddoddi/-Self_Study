import java.util.*;

class Solution {
    public int solution(String t, String p) {
        List<String> list = new ArrayList<>();
        for (int i=0; i<t.length() - p.length() +1; i++) {
            list.add(t.substring(i, i+p.length()));
        }
        
        long answer = list.stream()
            .filter(e -> e.compareTo(p) <= 0)
            .count();
        
        return (int)answer;
    }
}