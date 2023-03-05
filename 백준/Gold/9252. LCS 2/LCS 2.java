import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static String inputA, inputB;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        inputA = br.readLine();
        inputB = br.readLine();
        N = inputA.length();
        M = inputB.length();
        
        int ans = getLCSLength();

        StringBuilder sb = new StringBuilder();
        while ( N != 0 && M != 0) {
            if (inputA.charAt(N - 1) == inputB.charAt(M - 1)) {
                sb.insert(0, inputA.charAt(N - 1));
                N--;
                M--;
            } else if (dp[N][M] == dp[N - 1][M]) {
                N--;
            } else if (dp[N][M] == dp[N][M - 1]) {
                M--;
            }
        }

        bw.write(ans + "\n" + sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static int getLCSLength() {
        dp = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (inputA.charAt(i-1) == inputB.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[N][M];
    }
}