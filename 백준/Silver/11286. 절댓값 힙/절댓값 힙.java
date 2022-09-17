import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 첫 번째 줄 연산 개수 N
        // N개의 줄에 관련된 정보 나타내는 정수
        // 0이 주어진 횟수만큼 절대값 중 가장 작은 수, 둘 다 있으면 둘 중 작은 수 출력하고 제거

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

//        PriorityQueue<Integer> queue = new PriorityQueue<>(
//                new Comparator<Integer>() {
//                    @Override
//                    public int compare(Integer o1, Integer o2) {
//                        return Integer.compare(Math.abs(o1), Math.abs(o2));
//                    }
//                }
//        );

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            } else {
                return Math.abs(o1) - Math.abs(o2);
            }
        }
        );

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n==0) {
                if (queue.peek() == null) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.add(n);
            }
        }

        System.out.println(sb);
    }
}