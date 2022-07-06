import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(factorial2(n));
    }

    static int factorial2(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * factorial2(num-1);
        }
    }
}