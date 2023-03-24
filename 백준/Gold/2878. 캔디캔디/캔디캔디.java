import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int M,N;
    private static int[] want;
    private static long sum,ans;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken());

        want = new int[N];

        for (int i = 0; i < N; i++) {
            want[i] = Integer.parseInt(br.readLine()); 
            sum += want[i];
        }

        sum -= M;
        Arrays.sort(want);
        
        for (int i = 0; i < want.length; i++) {
            long w = Math.min(want[i], sum / N--);

            ans += w*w; 
            sum -= w; 
        }

        System.out.println(ans%((long)Math.pow(2, 64)));
    }
}