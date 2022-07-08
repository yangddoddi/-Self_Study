import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        boolean solvedIt = false;

        for ( int i=0; i<inputNum; i++ ) {
            int temp = i;
            int sum = i;

            while (temp > 0) {
                sum += temp % 10;
                temp = temp/10;
            }

            if (sum == inputNum) {
                System.out.println(i);
                solvedIt = true;
                break;
            }
        }

        if (!solvedIt) { System.out.println(0); }
        }
    }