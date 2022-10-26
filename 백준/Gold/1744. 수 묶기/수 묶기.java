
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        // 수열의 합, but 최대 2개의 수끼리 묶어 곱한 뒤 더할 수 있음
        // ex ) { 0, 1, 2, 3, 4, 5 } ?
        // => 0 + 1 + ( 2 * 3 ) + ( 4 * 5 ) == 최대값

        // 1. 큰 수끼리 곱하면 좋다.
        // 2. 0은 곱하면 안된다.
        // 3. 우선순위 큐를 쓰면 편하겠네요.
        // 4. 정답이 항상 2^31보다 작다고 한다.. long 쓰자..
        // 5. 문제는 음수다. 음수 양수를 따로 저장해야할 듯
        // 6. 음수의 경우 -> (절대값 기준)큰 수끼리 곱하면 좋다. 0이랑 곱해도 좋다.

        // 수열 크기 N
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐 생성
        Queue<Integer> positive = new PriorityQueue<>((n1, n2) -> n2 - n1);
        // 음수 우선순위 큐 생성 (기준 변경 필요)
        Queue<Integer> negative = new PriorityQueue<>((n1, n2) -> n1 - n2);

        int answer = 0;

        // 반복문 ( i < N )
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {
                answer += n;
            }
            else if (n > 0) {
                // 우선순위 큐에 수열 입력 받기
                positive.add(n);
            } else {
                // 만약 0 혹은 음수라면
                // 음수 우선순위 큐에 수열 입력 받기
                negative.add(n);
            }
        }

        // int answer = greedy(양수 큐, 음수 큐)
        long positiveResult = getSum(positive);
        long negativeResult = getSum(negative);
        answer += (positiveResult + negativeResult);

        // 정답 출력
        System.out.println(answer);
    }

    public static long getSum(Queue<Integer> queue) {
        // 양수 결과 변수 p
        // 음수 결과 변수 n
        long p = 0;

        // while(positive.size > 0)
        while (queue.size() > 0) {
            // num1 = positive.poll()
            int num1 = queue.poll();
            // 만약 다음 수가 없다면 p+=num1
            if (queue.isEmpty()) {
                p += num1;
            } else {
                // 아니라면 p += (num1*num2)
                int num2 = queue.poll();
                p += (num1 * num2);
            }
        }
        // while(negative.size > 0)
        // num1 = negative.poll()
        // 만약 다음 수가 없다면 n+=num1
        // 아니라면 n += (num1*num2)
        // 반환 p + n;

        return p;
    }
}