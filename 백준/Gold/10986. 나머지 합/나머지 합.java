
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        long[] arr = new long[N+1];
        long[] count = new long[M];
        long sum = 0;

        for (int i=1; i<=N; i++) {
            long input = Long.parseLong(st.nextToken());

            sum = input + arr[i-1];
            arr[i] = sum;

            count[(int) (arr[i]%M)]++;
        }

        long answer = count[0];
        for (int i=0; i< count.length; i++) {
            answer += count[i] * (count[i] - 1) / 2;
        }

        System.out.println(answer);
    }

}
