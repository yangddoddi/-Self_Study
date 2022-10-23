
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // N이 3 K 7 ?
        // 1 2 3
        // 2 3 6
        // 3 6 9

        // 1 2 2 3 3 3 6 6 9

        // 찾으려는 수 x는 N*N보다 작거나 같다.

        // 2*2 = 4, 4보다 작거나 같은 수 => 4개
        // 찾으려는 수 x는 K보다 작거나 같다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // i, j의 크기인 N 입력 받기
        int N = Integer.parseInt(br.readLine());
        // 찾으려는 인덱스 K 입력 받기
        int K = Integer.parseInt(br.readLine());

        // 이진탐색(시작 수(1), 큰 수, N)
        binary_search(1, K, N);
    }

    public static void binary_search(int low, int K, int N) {
        // l
        int l = low;
        // h
        int h = K;
        // m
        int m = 0;
        // a
        int a = 0;

        // 반복문 l <= hight
        while (l <= h) {
            // count
            int count = 0;
            // m = (l+h)/2
            m = (l + h) / 2;

            // 반복문 ( i <= N )
            for (int i = 1; i <= N; i++) {
                // int n = N/i;
                int n = m / i;
                // count += Math.min(N, n);
                count += Math.min(N, n);
                // => K가 12인 경우를 생각해보자.
            }

            // if ( k > count )
            if (K <= count) {
                // h = mid-1;
                h = m - 1;
            }

            if (K > count) {
                l = m + 1;
            }
        }

        System.out.println(l);
    }
}