import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // 수열 1 ~ n
        // 오큰수 NGE(i)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] temp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        stack.add(0);
        int[] answer = new int[N];

        for (int i=0; i<N; i++) {
            // 스택에 값을 넣다가, 기존 존재하는 값보다 큰 값이 들어오면 pop
            while(!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
                answer[stack.pop()] = temp[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }
}