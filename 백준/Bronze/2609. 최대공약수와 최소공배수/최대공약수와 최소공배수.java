import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int max = Math.max(num1,num2);
        int min = Math.min(num1,num2);

        int gcd = getGcd(max, min);
        int lcm = getLcm(max, min, gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    static int getGcd(int max, int min) {
        int temp = 0;

        for (;;) {
            temp = max%min;
            if ( temp == 0 ) { return min; }

            max = min;
            min = temp;
        }

    }

    static int getLcm(int n1, int n2, int gcd) {
        return n1*n2/gcd;
    }
}