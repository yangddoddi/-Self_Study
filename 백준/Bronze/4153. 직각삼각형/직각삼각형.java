import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private final static int SIDE = 3;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        double[] sideArr = new double[3];

        for (;;) {
            st = new StringTokenizer(br.readLine(), " ");
            int zeroCount = 0;

            for (int i = 0; i < SIDE; i++) {
                sideArr[i] = Math.pow(Integer.parseInt(st.nextToken()), 2);
                if ( sideArr[i] == 0 ) zeroCount++;
            }
            
            if (zeroCount==3) break;

            if (sideArr[0] + sideArr[1] == sideArr[2] ||
                    sideArr[0] + sideArr[2] == sideArr[1] ||
                    sideArr[1] + sideArr[2] == sideArr[0]) {
                sb.append("right").append("\n");
            } else {
                sb.append("wrong").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}