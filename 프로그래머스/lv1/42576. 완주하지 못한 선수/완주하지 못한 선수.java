import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<participant.length-1; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        if (participant[participant.length-1] != completion[participant.length-2]) {
            return participant[participant.length-1];
        }
        
        return null;
    }
}