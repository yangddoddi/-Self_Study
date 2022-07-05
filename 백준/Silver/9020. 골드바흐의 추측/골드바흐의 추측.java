import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] numArr = new boolean[10001];

    public static void main(String[] args) throws IOException {
        getPrimeNum();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while ( testCase-- > 0 ) {
            int inputNum = Integer.parseInt(br.readLine());

            int index1 = inputNum/2;
            int index2 = inputNum/2;

            for (;;) {
                if ( !numArr[index1] && !numArr[index2] ) {
                    System.out.println(index1 + " " + index2);
                    break;
                }
                index1--;
                index2++;
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
