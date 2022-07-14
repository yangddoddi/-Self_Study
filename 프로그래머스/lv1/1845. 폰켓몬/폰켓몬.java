import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> myMonsters = new HashSet<>();
        for (int n : nums) {
            if (myMonsters.size() == nums.length/2) { return myMonsters.size();}
            myMonsters.add(n);
        }
        return myMonsters.size();
    }
}