import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] board;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N];
        nQueen(0, N);

        System.out.println(answer);
    }

    private static void nQueen(int depth, int n) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i=0; i<n; i++) {
            board[depth] = i;

            if (isPossible(depth)) {
                nQueen(depth+1, n);
            }
        }
    }

    private static Boolean isPossible(int col) {
        for (int i=0; i<col; i++) {
            if (board[i] == board[col]) return false;

            if (Math.abs(board[col] - board[i]) == Math.abs(col-i)) return false;
        }

        return true;
    }
}