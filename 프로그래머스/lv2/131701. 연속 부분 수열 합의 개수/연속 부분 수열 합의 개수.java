import java.util.*;

class Solution {
    public int solution(int[] elements) {
        List<Integer> list = new ArrayList<>();
        
        for (int e : elements) {
            list.add(e);
        }
        
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        int len = 1;
        
        while (len <= elements.length) {
            
            for (int i=0; i<elements.length; i++) {
                int temp = list.get(i);
                
                for (int j=i+1; j<i+len; j++) {
                    temp += list.get(j % elements.length);
                }

                set.add(temp);
            }
            
            len++;
        }
        
        return set.size();
    }
}