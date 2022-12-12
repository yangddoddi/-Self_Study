import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        
        for (int n : arr) {
            if (list.size() == 0 || list.peekLast() != n) {
                list.add(n);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = list.poll();
        }
        
        return answer;
    }
}