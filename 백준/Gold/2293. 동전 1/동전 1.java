import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArr = br.readLine().split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int K = Integer.parseInt(inputArr[1]);

        int[] coins = new int[N];
        int[] dp = new int[K+1];

        for (int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        for (int i=0; i<coins.length; i++) {
            for (int j=1; j<=K; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j-coins[i]];
                }
            }
        }

        System.out.println(dp[K]);
    }
}
