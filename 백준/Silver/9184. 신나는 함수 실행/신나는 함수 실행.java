import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a==-1 && b==-1 && c==-1) { System.exit(0); }
            System.out.printf("w(%d, %d, %d) = %d%n", a, b, c, w(a,b,c));
        }
    }

    static Integer[][][] memo = new Integer[51][51][51];
    public static Integer w(int a, int b, int c) {
        if ( a<=0 || b<=0 || c<=0 ) { return 1; }
        if (memo[a][b][c] != null) { return memo[a][b][c]; }
        if ( a>20 || b>20 || c> 20) { return memo[a][b][c] = w(20, 20, 20); }
        if ( a<b && b<c) { return memo[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c); }
        return memo[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
    }
}