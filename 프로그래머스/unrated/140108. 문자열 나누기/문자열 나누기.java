import java.util.*;

class Solution {
    public int solution(String s) {   
        Queue<String> queue = new LinkedList<>();
        
        String[] arr = s.split("");
        for (String str : arr) {
            queue.add(str);
        }
        
        String first = "";
        int otherCnt = 0;
        int firstCnt = 0;
        int answer = 0;
        while (!queue.isEmpty()) {
            String str = queue.poll();
            
            if (first.equals("")) {
                firstCnt++;
                first = str;
                
                if (queue.size() == 0) {
                    answer++;
                }
                
                continue;
            }
            
            if (first.equals(str)) {
                firstCnt++;
            }
            
            if (!first.equals(str)) {
                otherCnt++;
            }
            
            if (firstCnt == otherCnt) {
                answer++;
                otherCnt = 0;
                firstCnt = 0;
                first = "";
            }
            
            if (queue.size() == 0 && firstCnt !=0) {
                   answer++;
               }
        }
        
        return Math.max(answer, 1);
    }
}