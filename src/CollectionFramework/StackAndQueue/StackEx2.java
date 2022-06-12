package CollectionFramework.StackAndQueue;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import static jdk.nashorn.tools.ShellFunctions.input;

public class StackEx2 {
    public static void main(String[] args) {
        System.out.println( "괄호 '()'가 포함된 문장을 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Character> stack = new Stack<>();


            try {
                for (int i = 0; i < input.length(); i++) {
                    if ('(' == input.charAt(i)) {
                        stack.push('(');
                    }
                    if (')' == input.charAt(i)) {
                        stack.pop(); // 만약
                    }
                }
                if (input.isEmpty())
                { System.out.println("괄호가 일치합니다."); }
                else
                { System.out.println("괄호가 닫히지 않았습니다. "); };
            } catch (EmptyStackException e) {
                System.out.println("괄호가 올바르게 입력되지 않았습니다.");
            }
    }
}
