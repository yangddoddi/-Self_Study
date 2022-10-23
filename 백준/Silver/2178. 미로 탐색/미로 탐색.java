import java.util.*;
import java.io.*;

public class Main {
    // 상하좌우 이동용 배열 생성
    private static final int[] dr1 = {1,0,-1,0};
    private static final int[] dr2 = {0,1,0,-1};
    private static final int FOUR_WAY = 4;
    // 방문 기록용 배열 생성
    private static boolean[][] visited;
    // 지도 기록용 2차원 배열 생성
    private static int[][] map;
    // N, M
    private static int N;
    private static int M;
    // 정답
    private static int[][] answer;

    public static void main(String[] args) throws Exception {
        // 4차원 배열 찾기 문제 특) 상하좌우 이동용 배열 필요함
        // 최단거리 문제 특) bfs가 좋다
        // 값이 많아봐야 10000개 -> 뭘로 해도 풀긴 할 듯

        // 정수 N, M 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        // 지도 초기화
        map = new int[N][M];
        answer = new int[N][M];

        // 이중 반복문
        // N번만큼 반복하며 M개의 수 배열에 입력
        for (int i=0; i<N; i++) {
            String[] strArr = br.readLine().split("");

            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        // visited 초기화
        visited = new boolean[N][M];

        // bfs 시작
        bfs(new int[]{0,0});

        System.out.println(answer[N-1][M-1]);
    }

    private static void bfs(int[] node) {
        //큐 생성
        Queue<int[]> queue = new ArrayDeque<>();
        //큐에 노드 삽입
        queue.add(node);
        visited[0][0]=true;
        answer[0][0] += 1;

        //While (널이 아닐 때까지)
        while (!queue.isEmpty()) {
            // 큐에서 가장 앞의 인자 빼기
            int[] next = queue.poll();

            // 반복문 (4방향 돌면서 체크)
            for (int i=0; i<FOUR_WAY; i++) {
                // 조건문 (ArrayIndexOutOfBoundsException 일어나지 않는다면 && 1인가요)
                int x = next[1] + dr1[i];
                int y = next[0] + dr2[i];

                if (x>=0 && x<map[0].length && y>=0 && y<map.length && !visited[y][x] && map[y][x]==1) {
                    queue.add(new int[]{y, x});
                    visited[y][x] = true;
                    answer[y][x] = answer[next[0]][next[1]] + 1;
                }
                // 만약 방문한 적 없다면
                // x랑 y를 q에 넣어주세요.
                // 방문 체크해주세요.
            }
        }
    }
}