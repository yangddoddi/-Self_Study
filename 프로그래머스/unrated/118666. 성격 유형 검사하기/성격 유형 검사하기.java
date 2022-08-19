import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> result = new HashMap<>();
        String[] type = {"R","T","C","F","J","M","A","N"};

        for (int i=0; i<survey.length; i++) {
            String firstChar = survey[i].substring(0,1);
            String secondChar = survey[i].substring(1,2);
            if (choices[i] < 4) {
                int point = 4-choices[i];
                if (result.getOrDefault(firstChar, null) == null) {
                    result.put(firstChar, point);
                } else {
                    result.put(firstChar, result.get(firstChar)+point);
                }
            } else if (choices[i] > 4) {
                int point = choices[i]-4;
               if (result.getOrDefault(secondChar, null) == null) {
                    result.put(secondChar, point);
                } else {
                    result.put(secondChar, result.get(secondChar)+point);
                }
            }
        }
        
        for (int i=0; i<type.length; i+=2) {
            int first = result.getOrDefault(type[i], 0);
            int second = result.getOrDefault(type[i+1], 0);
            
            if (first > second) answer.append(type[i]);
            else if (second > first) answer.append(type[i+1]);
            else if (second == first) answer.append(type[i]);
        }
        
        return answer.toString();
    }
}