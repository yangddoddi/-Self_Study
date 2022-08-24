import java.util.*;
import java.io.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, ArrayList<String>> result = new HashMap<>();
        Map<String, Integer> counter = new HashMap<>();
        StringTokenizer st;
        
        for ( String s : report ) {
            st = new StringTokenizer(s, " ");
            
            String reporter = st.nextToken();
            String reported = st.nextToken();
            
            if ( !result.containsKey(reporter) ) {
            result.put(reporter, new ArrayList<String>());
            }
            
            if ( !result.get(reporter).contains(reported) ) {
                result.get(reporter).add(reported);
                counter.put(reported, counter.getOrDefault(reported, 0) + 1);
            }
        }
        
        List<String> blackList = counter.keySet()
            .stream().filter( key -> counter.get(key) >= k)
            .collect(Collectors.toList());
        
            for (int i = 0; i < id_list.length; i++) {
                if (result.containsKey(id_list[i])) {
                    for ( String s : blackList) {
                        if (result.get(id_list[i]).contains(s)) {
                            answer[i]+=1;
                        }
                    }
                }
            }
        
        return answer;
    }
}