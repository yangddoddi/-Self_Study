import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int itemCount = Integer.parseInt(input[0]);
        int maxWeight = Integer.parseInt(input[1]);

        int[] weights = new int[itemCount+1];
        int[] values = new int[itemCount+1];
        for (int i=1; i<=itemCount; i++) {
            input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int value = Integer.parseInt(input[1]);

            weights[i] = weight;
            values[i] = value;
        }

        int[][] dp = new int[itemCount+1][maxWeight+1];
        for (int i=1; i<=maxWeight; i++) {
            for (int j=1; j<=itemCount; j++) {
                dp[j][i] = dp[j-1][i];

                if (i - weights[j] >= 0) {
                    dp[j][i] = Math.max(dp[j-1][i], values[j] + dp[j-1][i-weights[j]]);
                }
            }
        }

        System.out.println(dp[itemCount][maxWeight]);
    }
}