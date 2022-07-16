import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int kind_coin = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int coinArr[] = new int[kind_coin];

        for (int i=0; i<kind_coin; i++) { // 동전 종류 (오름차순)
            coinArr[i] = Integer.parseInt(br.readLine());
        }
        // 여기까지 유저 입력값 처리

        // 그리디 알고리즘
        int result = 0;
        for (int i=coinArr.length-1; i>=0; i--) {
            while ( T - coinArr[i] >= 0 ) {
                result+=1;
                T -= coinArr[i];
            }
        }
        System.out.println(result);
    }
}