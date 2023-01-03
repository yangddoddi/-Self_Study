import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Node> stack = new Stack<>();

        for (int i=0; i<temperatures.length-1; i++) {
            stack.push(new Node(i, temperatures[i]));

            while (i < temperatures.length-1 && temperatures[i+1] <= stack.peek().temp) {
                stack.push(new Node(++i, temperatures[i]));
            }

            while (i < temperatures.length-1 && !stack.isEmpty() && stack.peek().temp < temperatures[i+1]) {
                Node node = stack.pop();
                answer[node.idx] = i + 1 - node.idx;
            }
        }

        return answer;
    }

    class Node {
        private int idx;
        private int temp;

        public Node(int idx, int temp) {
            this.idx = idx;
            this.temp = temp;
        }
    }
}