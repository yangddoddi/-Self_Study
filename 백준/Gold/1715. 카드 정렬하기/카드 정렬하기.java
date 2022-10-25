import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        // 카드 묶음 비교
        // 최소한의 비교 횟수 구하기

        // 10 20 40인 경우
        // ( 10 + 20 ) = 30
        // ( 30 + 40 ) = 70
        // => 100

        // ( 10 + 40 ) = 50
        // ( 50 + 20 ) = 70
        // => 120

        // => 작은 묶음부터 비교하는 것이 효율적이다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        while (queue.size()>1) {
            int card1 = queue.poll();
            int card2 = queue.poll();

            int sum = card1 + card2;
            answer += sum;
            queue.add(sum);
        }

        System.out.println(answer);
    }
}