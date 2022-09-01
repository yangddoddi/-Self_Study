import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int arrLength = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[] sumArr = new int[arrLength];
        int sum = 0;

        st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<arrLength; i++) {
            int num = Integer.parseInt(st.nextToken());

            sum += num;
            sumArr[i] = sum;
        }

        StringBuilder result = new StringBuilder();

        for (int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int index1 = Integer.parseInt(st.nextToken())-1;
            int index2 = Integer.parseInt(st.nextToken())-1;

            if ( index1 != 0 ) {
                result.append(sumArr[index2] - sumArr[index1 - 1]).append("\n");
            } else result.append(sumArr[index2]).append("\n");
        }

        System.out.println(result.toString());
    }
}
