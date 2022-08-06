import java.io.*;
import java.util.StringTokenizer;

public class Main {
    final static int SIGN = 4; // 사인 종류
    static int[] numArr; // 초기 입력값
    static int[] signArr = new int[SIGN]; // 사인 배열
    static int min = Integer.MAX_VALUE; // 최소값 대입할 변수
    static int max = Integer.MIN_VALUE; // 최대값 대입할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 수의 개수
        st = new StringTokenizer(br.readLine(), " ");
        numArr = new int[T];

        // 정수 입력
        for (int i = 0; i < T; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < SIGN; i++) {
            signArr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(numArr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    // 백트래킹 메서드
    private static void backtracking(int num, int index) {
        if (index == numArr.length) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i=0; i<signArr.length; i++) {
            if (signArr[i] > 0) {
                signArr[i]--;
                switch (i) {
                    case 0 :
                        backtracking(num+numArr[index], index+1);
                        break;
                    case 1 :
                        backtracking(num-numArr[index], index+1);
                        break;
                    case 2 :
                        backtracking(num*numArr[index], index+1);
                        break;
                    case 3 :
                        backtracking(num/numArr[index], index+1);
                        break;
                }

                signArr[i]++;
            }
        }
    }
}
