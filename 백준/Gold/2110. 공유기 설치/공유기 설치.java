import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static long answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int houseCount = Integer.parseInt(input[0]);
        int routerCount = Integer.parseInt(input[1]);

        int[] houseCoordinates = new int[houseCount];
        for (int i=0; i<houseCount; i++) {
            houseCoordinates[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houseCoordinates);
        getMaxLength(1, houseCoordinates[houseCoordinates.length-1] - houseCoordinates[0] + 1
                , houseCoordinates, routerCount);

        System.out.println(answer);
    }

    private static void getMaxLength(int low, int high, int[] houseCoordinates, int routerCount) {
        long l = low;
        long r = high;

        while (l < r) {
            long mid = (l+r) / 2;

            long prev = houseCoordinates[0];
            long cnt = 1;
            for (int i=1; i< houseCoordinates.length; i++) {
                if (houseCoordinates[i] - prev >= mid) {
                    cnt++;
                    prev = houseCoordinates[i];
                }
            }

            if (cnt < routerCount) {
                r = mid;
            } else {
                l = mid+1;
                answer = Math.max(answer, mid);
            }
        }
    }
}