import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] isCompositeNum = new boolean[246913];
        isCompositeNum[0] = isCompositeNum[1] = true;

        for (int i=0; i*i<=isCompositeNum.length; i++) {
            if (!isCompositeNum[i]) {
                for (int j=i*i; j<= isCompositeNum.length; j+=i) {
                    isCompositeNum[j] = true;
                }
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int inputNum = Integer.parseInt(br.readLine());
            int result = 0;
            if (inputNum == 0) { break; }

            for (int i=inputNum+1; i<=(inputNum*2); i++) {
                if (!isCompositeNum[i]) { result +=1; }
            }
            System.out.println(result);
        }
    }
}
