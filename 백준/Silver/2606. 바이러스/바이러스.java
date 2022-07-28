import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터 수(정점)
        int computers = Integer.parseInt(br.readLine());
        // 연결되어 있는 컴퓨터 쌍의 수(간선)
        int edges = Integer.parseInt(br.readLine());

        // 정점 생성(시작 번호 1)
        for (int i=0; i<computers+1; i++) {
            edgeList.add(new ArrayList<>());
        }

        // 간선 배열(무방향) 생성
        for (int i=0; i<edges; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int edge1 = Integer.parseInt(st.nextToken());
            int edge2 = Integer.parseInt(st.nextToken());

            edgeList.get(edge1).add(edge2);
            edgeList.get(edge2).add(edge1);
        }

        // 방문 체크 배열 생성 (시작이 1번)
        visited = new boolean[computers+1];

        dfs(1);

        System.out.println(count);
    }

    static void dfs(int computerNum) {
        // 이미 방문한 정점은 체크하지 않음
        visited[computerNum] = true;

        // 해당 컴퓨터(정점)에서 연결된 다른 컴퓨터(정점) 탐색
        for ( int n : edgeList.get(computerNum) ) {
            if ( !visited[n] ) {
                // 아직 방문하지 않았을 경우
                dfs(n);
                count++;
            }
        }
    }
}