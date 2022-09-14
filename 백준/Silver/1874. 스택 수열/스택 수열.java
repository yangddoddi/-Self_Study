import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        첫 번째 줄 수열 개수 N
//        1개의 줄에 수열 이루는 1 이상 n이하 정수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int[] num = new int[N];

        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        int count = 1;
        ArrayList<Integer> temp = new ArrayList<>();

        for(int i=0; i<N; i++) {

            while (stack.size()==0 || num[i] > stack.peek()) {
                stack.push(count++);
                sb.append("+").append("\n");
            }

            while (stack.size()!=0 && stack.peek() > num[i]) {
                stack.pop();
                sb.append("-").append("\n");
            }

            while (stack.size()!=0 && stack.peek() == num[i]) {
                temp.add(stack.pop());
                sb.append("-").append("\n");
            }

            if (temp.size() == N) {
                break;
            }
        }

        if (temp.size() != N) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}