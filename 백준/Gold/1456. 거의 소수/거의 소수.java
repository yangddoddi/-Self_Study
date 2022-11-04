import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 소수의 N제곱 = 거의 소수.
        // A <= 거의소수 <= B를 구하라.

        // 중요 : A와 B의 최대값은 10^14
        // A와 B 모두 Long 으로 받아야함.

        // 거의 소수가 소수의 N제곱이므로 B보다 작은 수까지 모두 제곱하면 Long으로도 overflow

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // A, B 입력 받기
        String[] arr = br.readLine().split(" ");
        // A)
        long A = Long.parseLong(arr[0]);
        // B
        long B = Long.parseLong(arr[1]);

        // 소수 배열 (boolean)
        boolean[] isNotPrimeNumArr = new boolean[10000000 + 1];
        // 에라토스테네스의 체(소수 배열)
        getCompositeNumArr(isNotPrimeNumArr);

        // 거의 소수 구하기 (소수 배열, A, B)
        long answer = getNearlyPrimeNumCount(isNotPrimeNumArr, A, B);

        System.out.println(answer);
    }

    // 에라토스테네스의 체
    public static void getCompositeNumArr(boolean[] isNotPrimeNumArr) {
    // 너무 쉬워서 생략
        isNotPrimeNumArr[0] = isNotPrimeNumArr[1] = true;
    // 10^7까지 모두 구해야 한다.
        for (int i=2; i< isNotPrimeNumArr.length; i++) {
            // 이유 => 10^14의 제곱근
            if (!isNotPrimeNumArr[i]) {
                for (int j=i+i; j<isNotPrimeNumArr.length; j+=i) {
                    isNotPrimeNumArr[j] = true;
                }
            }
        }
    }

    // 거의 소수 구하기
    public static long getNearlyPrimeNumCount(boolean[] isNotPrimeNumArr, long A, long B) {
        long count = 0;

        for (int i=0; i< isNotPrimeNumArr.length; i++) {
            if (!isNotPrimeNumArr[i]) {
                long temp = i;
                long curr = i;
                while ((double)curr <= (double)B/temp) {
                    if ((double)curr >= (double)A/temp) { count++; }
                    temp *= curr;

                    // 원래 범위 = while ( 소수^소수 <= B ) => Overflow
                    // 이항 연산 => while ( 소수 <= B/소수 )
                    //
                    // while (소수 <= B/소수)
                    // if (소수배열[I])
                    // { count++; }
                }
            }
        }
        return count;
    }
}