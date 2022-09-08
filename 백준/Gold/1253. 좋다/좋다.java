import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 첫 번째 줄 입력값 : 수의 개수 N
        // 두 번째 줄 입력값 : N개의 수의 값 (1,000,000,000보다 작거나 같은 정수)
        // 주어진 N개의 수 중에서 다른 두 수의 합으로 표현되는 수가 있다면?

        // 정렬 및 투포인터
        // 자기 자신을 포함하면 안됨

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i=0; i<N; i++) {
            int left = 0;
            int right = N - 1;
            int sum;

            while (left < right) {
                if ( left == i ) {
                    left++;
                }
                else if ( right == i ) {
                    right--;
                }
                else {
                    sum = arr[left] + arr[right];

                    if (sum == arr[i]) {
                        answer++;
                        break;
                    }

                    if (sum > arr[i]) {
                        right--;
                    }

                    if (sum < arr[i]) {
                        left++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}