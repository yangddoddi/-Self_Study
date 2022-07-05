import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] numArr = new boolean[10001];

    public static void main(String[] args) throws IOException {
        getPrimeNum();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t=0; t<testCase; t++) {
            int inputNum = Integer.parseInt(br.readLine());
            loop : for (int i=inputNum/2; i<inputNum; i++) {
                for (int j=inputNum/2; j>0; j--) {
                    if (!numArr[i] && !numArr[j]) {
                        if ( inputNum - i - j == 0 )
                        {
                            System.out.println(j + " " + i);
                            break loop;
                        }
                    }
                }
            }
        }
    }


    // 소수 구하기
  static boolean[] getPrimeNum() {
     numArr[0] = numArr[1] = true;

     for (int i = 0; i*i < numArr.length; i++) {
         if ( !numArr[i] ) {
             for (int j = i*i; j < numArr.length; j+=i ) {
                 numArr[j] = true;
             }
         }
     }

     return numArr;
 }
}