import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static String[][] board;
    private static int[] coinA;
    private static int[] coinB;
    private static boolean[][][][] visited;
    private static int[] moveColumn = new int[]{1,-1,0,0};
    private static int[] moveRow = new int[]{0,0,1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int row = Integer.parseInt(input[0]);
        int column = Integer.parseInt(input[1]);

        // 동전이 이동하려는 칸이 벽이면 이동하지 않음
        // 동전 이동 방향에 칸이 없으면 밖으로 떨어짐
        // 이외의 경우에는 한 칸 이동(동전이 있어도 이동)

        board = new String[row][column];
        visited = new boolean[row][column][row][column];
        for (int i=0; i<row; i++) {
            input = br.readLine().split("");

            for (int j=0; j<column; j++) {
                board[i][j] = input[j];

                if (input[j].equals("o")) {
                    coinA = (coinA == null) ? new int[]{i, j} : coinA;
                    coinB = new int[]{i, j};
                }
            }
        }

        bfs();
    }

    private static void bfs() {
        Queue<TwoCoin> queue = new LinkedList<>();
        queue.add(new TwoCoin(coinA[1], coinA[0], coinB[1], coinB[0], 0));

        while (!queue.isEmpty()) {
            TwoCoin current = queue.poll();

            for (int i=0; i< moveColumn.length; i++) {
                int nextARow = current.coinARow + moveRow[i];
                int nextAColumn = current.coinAColumn + moveColumn[i];
                int nextBRow = current.coinBRow + moveRow[i];
                int nextBColumn = current.coinBColumn + moveColumn[i];

                try {
                    if (board[nextARow][nextAColumn].equals("#")) {
                        nextARow = current.coinARow;
                        nextAColumn = current.coinAColumn;
                    }
                } catch (Exception ignored) {}

                try {
                    if (board[nextBRow][nextBColumn].equals("#")) {
                        nextBRow = current.coinBRow;
                        nextBColumn = current.coinBColumn;
                    }
                } catch (Exception ignored) {}

                TwoCoin next = current.create(nextAColumn, nextARow, nextBColumn, nextBRow);

                if (next.isSingleCoinDropped()) {
                    System.out.println((next.count > 10) ? -1 : next.count);
                    System.exit(0);
                }

                if (next.areBothCoinsDropped()) continue;

                if (!visited[next.coinARow][next.coinAColumn][next.coinBRow][next.coinBColumn]) {
                    visited[next.coinARow][next.coinAColumn][next.coinBRow][next.coinBColumn] = true;
                    queue.add(next);
                }
            }
        }

        System.out.println(-1);
    }

    private static class TwoCoin {
        private int coinAColumn;
        private int coinARow;
        private int coinBColumn;
        private int coinBRow;
        private int count;

        public TwoCoin(int coinAColumn, int coinARow, int coinBColumn, int coinBRow, int count) {
            this.coinAColumn = coinAColumn;
            this.coinARow = coinARow;
            this.coinBColumn = coinBColumn;
            this.coinBRow = coinBRow;
            this.count = count;
        }

        public TwoCoin create(int coinAColumn, int coinARow, int coinBColumn, int coinBRow) {
            return new TwoCoin(coinAColumn, coinARow, coinBColumn, coinBRow, this.count + 1);
        }

        public boolean isSingleCoinDropped() {
            return (isCoinADropped() && !isCoinBDrooped()) || (isCoinBDrooped() && !isCoinADropped());
        }

        public boolean areBothCoinsDropped() {
            return isCoinADropped() && isCoinBDrooped();
        }

        private boolean isCoinADropped() {
            return this.coinAColumn < 0 || this.coinAColumn >= board[0].length || this.coinARow < 0 || this.coinARow >= board.length;
        }

        private boolean isCoinBDrooped() {
            return this.coinBColumn < 0 || this.coinBColumn >= board[0].length || this.coinBRow < 0 || this.coinBRow >= board.length;
        }
    }
}