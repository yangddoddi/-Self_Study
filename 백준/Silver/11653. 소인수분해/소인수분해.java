import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        int primeNum = 2;

        while ( inputNum != 1 ) {
            if ( inputNum % primeNum == 0 ) {
                inputNum /= primeNum;
                System.out.println(primeNum);
            } else {
                primeNum++;
            }
        }
    }
}