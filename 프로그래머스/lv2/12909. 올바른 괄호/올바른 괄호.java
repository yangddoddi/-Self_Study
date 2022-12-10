import java.util.*;

class Solution {
    boolean solution(String s) {
        // 반복문으로 스택에 s를 한 글자씩 담는다
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return (!stack.isEmpty()) ? false : true;
    }
}