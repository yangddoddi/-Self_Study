import java.util.*;

class Solution {
    // 1번 수포자 : 1 2 3 4 5
    // 2번 수포자 : 2 1 2 3 2 4 2 5 2 1 2 3 2 4 2 5
    // 3번 수포자 : 33 11 22 44 55 33 11 22 44 55
    public int[] solution(int[] answers) {
        int[] first = new int[]{1,2,3,4,5};
        int[] second = new int[]{2,1,2,3,2,4,2,5};
        int[] third = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int firstIdx = 0;
        int secondIdx = 0;
        int thirdIdx = 0;
        
        int firstScore = 0;
        int secondScore = 0;
        int thirdScore = 0;
        
        for (int i=0; i<answers.length; i++) {
            if (firstIdx == first.length) firstIdx = 0;
            if (secondIdx == second.length) secondIdx = 0;
            if (thirdIdx == third.length) thirdIdx = 0;
            
            if (first[firstIdx++] == answers[i]) firstScore++;
            if (second[secondIdx++] == answers[i]) secondScore++;
            if (third[thirdIdx++] == answers[i]) thirdScore++;
        }
        
        List<Integer> list = new ArrayList<>();
        
        int max = Math.max(firstScore, Math.max(secondScore, thirdScore));
        
        if (firstScore == max) list.add(1);
        if (secondScore == max) list.add(2);
        if (thirdScore == max) list.add(3);
        
        return list.stream()
            .mapToInt(e->e)
            .toArray();
    }
}