import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private final static int ANGLE = 4;
    private static boolean[] checkedX = new boolean[ANGLE-1];
    private static boolean[] checkedY = new boolean[ANGLE-1];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] x = new int[3];
        int[] y = new int[3];

        for (int i=0; i<ANGLE-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int inputX = Integer.parseInt(st.nextToken());
            int inputY = Integer.parseInt(st.nextToken());

            x[i] = inputX;
            y[i] = inputY;
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<ANGLE-2; i++) {
            for (int j = i+1; j < ANGLE - 1; j++) {
                if (x[i] == x[j]) {
                    checkedX[i] = true;
                    checkedX[j] = true;
                }
                if (y[i] == y[j]) {
                    checkedY[i] = true;
                    checkedY[j] = true;
                }
            }
        }
        

        for (int i=0; i< checkedX.length; i++) {
            if (!checkedX[i]) {
                sb.append(x[i]).append(" "); }
        }

        for (int i=0; i< checkedY.length; i++) {
            if (!checkedY[i]) { sb.append(y[i]); }
        }

        System.out.println(sb.toString());
    }
}