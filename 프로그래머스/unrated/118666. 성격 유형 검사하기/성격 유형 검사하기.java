import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<Integer, Integer> result = new HashMap<>();
        String[] type = {"R","T","C","F","J","M","A","N"};
        
        for (int i=0; i<survey.length; i++) {
            int point = 0;
            if (choices[i]>4) point = -(choices[i]-4);
            else if (choices[i]<4) point = 4-choices[i];
            
            switch(survey[i].substring(0,1)) {
                case "R" :
                    result.put(1, result.getOrDefault(1,0)+point);
                    break;
                case "T" :
                    result.put(1, result.getOrDefault(1,0)-point);
                    break;
                case "C" :
                    result.put(2, result.getOrDefault(2,0)+point);
                    break;
                case "F" :
                    result.put(2, result.getOrDefault(2,0)-point);
                    break;
                case "J" :
                    result.put(3, result.getOrDefault(3,0)+point);
                    break;
                case "M" :
                    result.put(3, result.getOrDefault(3,0)-point);
                    break;
                case "A" :
                    result.put(4, result.getOrDefault(4,0)+point);
                    break;
                case "N" :
                    result.put(4, result.getOrDefault(4,0)-point);
                    break;
            }
        }
        
        // if (result.getOrDefault(1,0) >= 0) ? sb.append("R") : sb.append("T");
        // if (result.getOrDefault(2,0) >= 0) ? sb.append("C") : sb.append("F");
        // if (result.getOrDefault(3,0) >= 0) ? sb.append("J") : sb.append("M");
        // if (result.getOrDefault(4,0) >= 0) ? sb.append("A") : sb.append("N");
        
        for (int i=0; i<4; i++) {
            if (result.getOrDefault(i+1,0) >= 0) answer.append(type[i*2]);
            else answer.append(type[(i*2)+1]);
        }
        
        return answer.toString();
    }
}