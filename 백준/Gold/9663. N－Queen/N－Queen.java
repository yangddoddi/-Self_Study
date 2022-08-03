import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N = 0; // 보드 위에 놓을 퀸 개수
    static int cnt = 0;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] board = new int[N];
        boolean[] check = new boolean[N];

        getQueenPositions(0, board);
        // 1차원 배열 혹은 2차원 배열 숫자 중 하나라도 같다면 안됨
        // [x+n, y+n]이면 안됨 [x-n, y-n]이면 안됨
        System.out.println(cnt);
    }

    public static void getQueenPositions(int n, int[] board) {
        if ( n == N ) {
            cnt++;
            return;
        }

        for (int i=0; i<N; i++) {
            check=true;
            board[n]=i;

            for (int j=0; j<n; j++) {
                if (board[j] == board[n] || Math.abs(n - j) == Math.abs(board[n] - board[j])) {
                    check=false;
                }
            }

            if (check) {
                getQueenPositions(n+1,board);
            }
        }
    }
}
