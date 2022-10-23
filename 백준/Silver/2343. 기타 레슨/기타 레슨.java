import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // 강의의 순서가 바뀌면 안된다.
        // 블루레이 개수는 최소 - 모든 블루레이 개수는 같아야 한다.
        // => 최소 블루레이의 크기는 가장 용량이 큰 강의와 같다.
        // => 최대 블루레이 크기는 모든 강의 용량의 합과 같다.

        // 강의 수 최대 100,000
        // n^2의 복잡도가 필요한 연산 사용 시 1,000,000,000
        // 제한시간 2초이므로 제일 넉넉한 기준인 초당 10억회 연산으로도 부족함
        // O(nlogn) => 500000
        // nlogn은 내가 아는 건 이진 탐색 뿐이다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 레슨 수 N, 블루레이 개수 M 입력 받기
        // 강의 배열 입력 arr
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 제일 큰 용량의 강의 저장 변수 max
        int max = 0;
        // 모든 강의 용량 저장 변수 sum
        int sum = 0;

        // N만큼 반복하며 N 크기의 배열에 강의 길이 입력 받기
        int[] lectures = new int[N];
        input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(input[i]);
            // lecture[i] = arr
            lectures[i] = n;
            // max = Math.max(max, arr[i])
            max = Math.max(max, n);
            // sum = arr[i-1] + arr[i]
            if ( i == 0 ) sum = n;
            else sum = sum + n + Integer.parseInt(input[i-1]);
        }

        // 이진탐색(강의 배열, 최대값, 누적합, 블루레이 개수)
        binary_search(lectures, max, sum, M);
    }

    // 이진탐색 (강의 배열, 최대값, 누적합, 블루레이 개수)
    public static void binary_search(int[] lectures, int minimum, int maximum, int M) {
        // 최소값 = 최대값
        int min = minimum;
        // 최대값 = 누적합
        int max = maximum;
        // 반복문 ( 최소값이 최대값보다 작거나 같은 동안 )
        int answer = 0;
        while (min<=max) {
            // 중간값 = (최소값+최대값) / 2
            int mid = (min+max) /2;
            // 카운트 = 0;
            int count = 0;
            // 합계 = 0;
            int sum = 0;
            //
            // 반복문 (강의 배열 길이만큼) {
            for (int i=0; i< lectures.length; i++) {
                // i 부터 더하자
                if ( sum + lectures[i] > mid ) {
                    count+=1;
                    sum = 0;
                }

                // 만약 합계가 중간값과 같거나 크다면?
                sum += lectures[i];
                    // 카운트 증가
                    // 합계 초기화
            }
            //
            // 만약 합계가 0이 아니라면?
            if (sum !=0) {
                // 카운트 증가
                count++;
            }
            //
            // 만약 카운트가 블루레이 개수보다 작거나 같다면?
            if (count <= M) {
                // 최대값 = 중간값-1
                max = mid-1;
                answer = mid;
            }
            //
            // 만약 카운트가 블루레이 개수보다 크다면?
            if (count > M) {
                // 최소값 = 중간값+1
                min = mid+1;
            }
        }
        System.out.println(answer);
        // 탐색이 모두 끝나면 출력
    }
}