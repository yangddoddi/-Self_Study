import java.util.*;

class Solution {
    public int solution(int[] numbers) {
    ArrayList<Integer> numList = new ArrayList<>();
    int sum = 0;    
        
    for (int i=0; i<numbers.length; i++) {
        numList.add(numbers[i]);
    }
        
    for (int i=0; i<=9; i++) {
        if (!numList.contains(i)) sum+=i;
    }
        
    return sum;
    }
}