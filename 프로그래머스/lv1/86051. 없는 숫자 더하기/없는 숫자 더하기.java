import java.util.*;

class Solution {
    public int solution(int[] numbers) {
    ArrayList<Integer> numList = new ArrayList<>();
    
    for (int i=0; i<10; i++) {
    numList.add(i);
    }
    
    for (int n : numbers) {
    numList.remove(Integer.valueOf(n));
    }
    
    return numList.stream().mapToInt(m->m).sum();
    }
}