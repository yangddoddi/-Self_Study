import java.io.*;

public class Main {
    static int MAX = 1_000_000;
    // 각 자리의 숫자 순서를 뒤집은 수 -> 팰린드롬
    // 79197 <-> 324423

    // N보다 크거나 같으면서 소수인 수 중 팰린드롬인 수를 찾을 것.
    // N의 범위 <= 1,000,000 . int로 받을 수 있다.

    // 팰린드롬 구하는 방법 유추
    // 1. 1,000,000까지의 소수를 모두 구한다.
    // 2. 입력받은 수를 문자열 배열로 변환하고, 배열의 시작과 끝부터 문자열을 검사한다.
    // 3. 만약 두 문자열이 일치하지 않는 경우 다음으로 넘어간다.
    // 4. 만약 두 포인터가 서로 만나거나 교차하면 팰린드롬 수라고 판단할 수 있다.
    public static void main(String[] args) throws Exception {
        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 소수 체크용 boolean 배열
        boolean[] isNotPrimeNum = new boolean[MAX*2+1];
        // 에라토스테네스의 체
        getPrimeNums(isNotPrimeNum);

        // 펠린드롬 구하기(소수 배열, N)
        int answer = getPelinedromeNum(isNotPrimeNum, N);

        // 정답 출력
        System.out.println(answer);
    }

    // 에라토스테네의 체 (소수 체크 배열)
    public static void getPrimeNums(boolean[] arr) {
        // 배열 [0] = 배열 [1] = true
        arr[0] = arr[1] = true;
        // 반복문 ( i*i <= 1,000,000 )
        for (int i=2; i*i <= arr.length; i++) {
            //  if ( 배열[i] = false ) {
            if (!arr[i]) {
                for (int j=i+i; j < arr.length; j+=i) {
                    //    반복문 ( j=i+i; j <= 1,000,000 j+=i ) {
                    arr[j] = true;
                    //       배열[j] = true;
                }
            }
        }
    }

    // 펠린드롬 구하기 (소수 배열, N)
    public static int getPelinedromeNum(boolean[] isNotPrimeNum, int N) {
        // n = N;
        int n = N;

        // while ( true ) 0 1 2 3

        while (true) {
            if (!isNotPrimeNum[n]) {
                // String 배열 = String.valueOf(n);
                String[] arr = String.valueOf(n).split("");
                // l = 0;
                int l = 0;
                // r = 배열.length()-1;
                int r = arr.length - 1;
                //    while ( r >= l && 배열[l].equals(배열[r]) ) {
                while (r >= l && arr[l].equals(arr[r])) {
                    //          if ( r == l ) return n;
                    //    }
                    l++;
                    r--;
                    if (r <= l) return n;
                }
                // n++
                // }
            }
            n++;
        }
    }
}