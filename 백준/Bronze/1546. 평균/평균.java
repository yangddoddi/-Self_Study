import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Double[] arr = new Double[N];
        Double max = 0d;
        Double avg = 0d;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<N; i++) {
            Double num = Double.parseDouble(st.nextToken());

            max = Math.max(num, max);
            arr[i] = num;
        }

        for (int i=0; i<N; i++) {
            arr[i] = arr[i]/max*100.0;
            avg += arr[i];
        }

        System.out.println(avg/N);
    }
}