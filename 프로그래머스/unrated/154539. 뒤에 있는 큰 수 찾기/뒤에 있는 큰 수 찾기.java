import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<int[]> stack = new Stack<>();
        List<int[]> list = new ArrayList<>();

        for (int i=0; i<numbers.length-1; i++) {
            stack.push(new int[]{i, numbers[i]});
            
            while (!stack.isEmpty() && stack.peek()[1] < numbers[i+1]) {
                list.add(stack.pop());
            }
        }
        
        while (!stack.isEmpty()) {
            list.add(new int[]{stack.pop()[0], -1});
        }
        
        return list.stream()
            .sorted((e1,e2) -> e1[0] - e2[0])
            .mapToInt(e -> e[1])
            .toArray();
    }
}