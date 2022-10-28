import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        // 각 회의마다 시작시간, 끝나는 시간 주어짐
        // 회의가 겹치지 않게 하면서 사용할 수 있는 회의 최대 개수
        // 회의는 도중에 중단될 수 없음

        // {1, 4} {5, 7} {6, 10} {2, 13}
        // {3, 5} {3, 8} {8, 11} {12, 14}
        // {0, 6} {5, 9} {8, 12}

        // 최소값이 0 최대값이 14
        // 1. n2가 작을 수록 좋다.
        // 2. n2 - n1이 작을 수록 좋다.
        // 3. n2와 다음 n1의 차이가 작을 수록 좋다.

        // 그리티 알고리즘은 "해당 순간에 가장 최선인 경우를 모두 탐색하는 것"
        // 1. 1-4 0-6 ? 1-4
        // 2. 5-7 5-9 ? 5-7
        // 3. 8-11, 8-12 ? 8-11
        // 4. 12-14

        // 시작 시간과 끝나는 시간은 2^31-1 == 정수형(Integer)의 범위를 의미한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 회의의 수 N을 입력 받는다.
        int N = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new PriorityQueue<>((n1, n2) -> {
            if (n1[1] == n2[1]) {
                return n1[0] - n2[0];
            }
            else  return n1[1] - n2[1];
        });
        // 반복문 (i<N)
        for (int i=0; i<N; i++) {
            // 우선 순위 큐(정렬 기준 n2).push(배열)
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            queue.add(arr);
        }

        // int answer = findBestValue(큐)
        int answer = findBestValue(queue);
        // 출력
        System.out.println(answer);
    }

    public static int findBestValue(Queue<int[]> queue) {
        // count = 0
        int count = 0;
        // arr = null
        int[] arr = null;
        // while (!queue.empty) {
        while (!queue.isEmpty()) {
            // temp = queue.poll
            int[] temp = queue.poll();
            // if ( arr에 등록된 배열의 n2보다 temp의 n1이 크다면 )
            if (arr == null || arr[1] <= temp[0]) {
                // arr = temp;
                arr = temp;
                // count ++;
                count++;
            }
            // }
        }
        // 반환
        return count;
    }
}