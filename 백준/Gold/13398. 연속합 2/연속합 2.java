import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int[] dpL = new int[N];
        int[] dpR = new int[N];

        int answer = nums[0];
        dpL[0] = nums[0];
        for (int i=1; i<N; i++) {
            dpL[i] = Math.max(nums[i], dpL[i-1] + nums[i]);
            answer = Math.max(dpL[i], answer);
        }

        dpR[N-1] = nums[N-1];
        for (int i=N-2; i>=0; i--) {
            dpR[i] = Math.max(nums[i], dpR[i+1] + nums[i]);
            answer = Math.max(dpR[i], answer);
        }

        for (int i=1; i<N-1; i++) {
            int temp = dpL[i-1] + dpR[i+1];
            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
    }
}
