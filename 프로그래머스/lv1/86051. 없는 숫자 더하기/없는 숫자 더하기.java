import java.util.*;

class Solution {
    public int solution(int[] numbers) {
    ArrayList<Integer> nums = new ArrayList<>();
    
    for (int i=0; i<=9; i++) {
        nums.add(i);
    }
        
    return nums.stream()
        .filter(num -> Arrays.stream(numbers).noneMatch(n->n==num))
        .mapToInt(m->m)
        .sum();
    }
}