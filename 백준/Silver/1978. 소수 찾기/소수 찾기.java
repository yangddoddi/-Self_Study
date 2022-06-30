import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        boolean[] booleans = new boolean[1000+1];
        booleans[0] = booleans[1] = true;

        for ( int i=0; i*i< booleans.length; i++) {
            if (!booleans[i]) {
                for (int j = i * i; j < booleans.length; j += i) {
                    booleans[j] = true;
                }
            }
        }

        int result = 0;
        for ( int i=0; i<T; i++ ) {
            if (!booleans[Integer.parseInt(scanner.next())]) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}