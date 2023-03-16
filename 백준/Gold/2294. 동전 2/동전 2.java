import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int coinCount = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);

        int[] coins = new int[coinCount];
        for (int i=0; i<coinCount; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        coins = Arrays.stream(coins)
                .boxed()
                .sorted((a,b) -> a-b)
                .distinct()
                .mapToInt(e -> e)
                .toArray();

        int[] dp = new int[target+1];
        Arrays.fill(dp , 10001);
        dp[0] = 0;

        for (int c : coins) {
            for (int i = c; i <= target; i++) {
                dp[i] = Math.min(dp[i], dp[i-c] + 1);
            }
        }

        System.out.println((dp[target] == 10001) ? -1 : dp[target]);
    }
}