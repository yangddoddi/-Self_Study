import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mod = 1_000_000_000;

        long[][] dp = new long[N+1][10];
        for (int i=1; i<10; i++) {
            dp[1][i] = 1;
        }

        for (int i=2; i<=N; i++) {
            for (int j=0; j<10; j++) {
                if (j == 9) dp[i][9] = dp[i-1][8] % mod;

                if (j == 0) dp[i][0] = dp[i-1][1] % mod;

                if (j != 9 && j != 0) dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }

        long answer = 0;
        for (int i=0; i<10; i++) {
            answer += dp[N][i];
        }

        System.out.println(answer % mod);
    }
}
