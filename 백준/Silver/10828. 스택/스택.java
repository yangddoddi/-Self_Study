import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> stack = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            String input = br.readLine();
            int lastIndex = stack.size()-1;

            if ( input.startsWith("push") ) {
                String[] inputArr = input.split(" ");
                int inputNum = Integer.parseInt(inputArr[1]);

                stack.add(inputNum);
            }

            else if ( input.equals("pop") ) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.get(lastIndex));
                    stack.remove(lastIndex);
                }
            }

            else if ( input.equals("size") ) {
                System.out.println(stack.size());
            }

            else if ( input.equals("empty") ) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

            else if ( input.equals("top") ) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.get(lastIndex));
                }
            }
        }
    }
}