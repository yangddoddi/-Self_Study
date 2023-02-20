import java.util.*;
import java.util.stream.*;

class Solution {
    // 낳이 재생된 장르 먼저
        // 장르에서 많이 재생된 노래 먼저
        // 장르에서 재생 횟수가 같다면 고유 번호가 낮은 것부터
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new LinkedHashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> keys = map.entrySet()
            .stream()
            .sorted((a,b) -> b.getValue() - a.getValue())
            .map(e -> e.getKey())
            .collect(Collectors.toList());
        
        List<Integer> list = new ArrayList<>();
        for (String k : keys) {
            int first = -1;
            for (int i=0; i<genres.length; i++) {
                if (genres[i].equals(k) && first == -1) {
                    first = i;
                }
                
                if (genres[i].equals(k) && plays[first] < plays[i]) {
                    first = i;
                }
            }
            plays[first] = 0;
            
            int second = -1;
            for (int i=0; i<genres.length; i++) {
                if (genres[i].equals(k) && second == -1) {
                    second = i;
                }
                
                if (genres[i].equals(k) && plays[second] < plays[i]) {
                    second = i;
                }
            }
            
            list.add(first);
            
            if (plays[second] > 0) {
                list.add(second);
            }
        }
        
        return list.stream()
            .mapToInt(e -> e)
            .toArray();
    }
}