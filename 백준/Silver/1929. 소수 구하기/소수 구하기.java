import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int minNum = Integer.parseInt(st.nextToken());
        int maxNum = Integer.parseInt(st.nextToken());

        boolean[] isCompositeNum = new boolean[10000001];
        isCompositeNum[0] = isCompositeNum[1] = true;
        // 1과 0은 합성수도 소수도 아니다.. 임의 표현

        for ( int i = 0; i*i <= maxNum; i++ ) {
            if ( !isCompositeNum[i] ) {
                for ( int j=i*i; j <= maxNum; j+=i) {
                    isCompositeNum[j] = true;
                }
            }
        }

        for ( int i=minNum; i<=maxNum; i++) {
            if (!isCompositeNum[i]) {
                System.out.println(i);
            }
        }
    }
}