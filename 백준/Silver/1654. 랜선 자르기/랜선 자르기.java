import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static long answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int cableCount = Integer.parseInt(input[0]);
        int needCableCount = Integer.parseInt(input[1]);

        long maxLength = 0;
        long[] cables = new long[cableCount];
        for (int i=0; i<cableCount; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            maxLength = Math.max(cables[i], maxLength);
        }

        getMaxLength(0, maxLength+1, cables, needCableCount);
        System.out.println(answer);
    }

    private static void getMaxLength(long low, long high, long[] cables, long target) {
        long l = low;
        long r = high;

        while (l < r) {
            long mid = (l + r) / 2;

            long count = 0;
            for (long lan : cables) {
                count += (lan / mid);
            }

            if (count < target) {
                r = mid;
            } else {
                l = mid+1;
                answer = Math.max(mid, answer);
            }
        }
    }
}