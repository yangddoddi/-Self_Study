import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] height = new int[T];
        int[] weight = new int[T];
        int[] rating = new int[T];

        for(int i=0; i<T; i++) {
            String[] bulkInput = br.readLine().split(" ");
            height[i] = Integer.parseInt(bulkInput[0]);
            weight[i] = Integer.parseInt(bulkInput[1]);
        }

        for(int i=0; i<T; i++) {
            rating[i] = 1;
            for(int j=0; j<T; j++) {
                if ( height[i] < height[j] && weight[i] < weight[j] ) {
                    rating[i]++;
                }
            }
        }

        for (int result : rating) {
            System.out.printf(result+" ");
        }
    }
}