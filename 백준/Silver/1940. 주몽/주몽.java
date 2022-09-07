import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 주어진 N개의 수 중 두 개를 골라 M을 만들면
        // 첫째 입력 - 재료 개수 N
        // 둘째 입력 - 필요한 수 M
        // 세번째 입력 - 각 재료 번호

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long M = Long.parseLong(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start_index = 0;
        int end_index = N-1;
        long sum = 0;
        int answer = 0;

        while (start_index<end_index) {
            sum = arr[start_index] + arr[end_index];
            if (sum==M) {
                answer++;
                end_index--;
            }
            if (sum>M) {
                end_index--;
            }
            if (sum<M) {
                start_index++;
            }
        }

        System.out.print(answer);
    }
}