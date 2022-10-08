import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // 첫째 줄에 사람 수 N과 친구 관계의 수 M이 주어진다.
        // 둘째 줄부터 정수 a b가 주어지며 a와 b가 친구라는 뜻
        // 모든 친구 관계가 이어진다면 1 출력 아니면 0 출력

        // 친구 관계는 양방향이므로 무방향 그래프
        // a-b-c-d ..가 한 번에 이어지는 것인지 체크하는 게 목적이므로 dfs

        // N과 M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 반복문
        // ArrayList<ArrayList<Integer>>에 N만큼 ArrayList 삽입
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i=0; i<N; i++) {
            lists.add(new ArrayList<>());
        }

        // 반복문 (M 수만큼) -> 이 문제에서는 M이 Edge 수다.
        // list.get(a).add(b)
        // lisg.get(b).add(a)
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            lists.get(num1).add(num2);
            lists.get(num2).add(num1);
        }

        // 방문 여부 체크 배열

        // 반복문
        boolean[] visited = new boolean[N];
        for (int i=0; i<N; i++) {
            Arrays.fill(visited,false);
            dfs(i,lists, visited, 0);
        }
        // (해당 정점을 탐색하지 않았을 시 ?)
        // dfs (정점, 방문여부 체크, 깊이) 실행
        System.out.println(0);
    }

    // 평범한 dfs
    // dfs(정점, 방문여부체크, 깊이)
    public static void dfs(int V, ArrayList<ArrayList<Integer>> lists, boolean[] visited, int depth) {
        if (depth == 4) {
            System.out.println(1);
            System.exit(0);
        }
        // if (깊이 == N?) answer = 1;

        visited[V] = true;
        // if (방문했나요?) return
        // 안했다면 방문 true
        for (int i=0; i< lists.get(V).size(); i++) {
            int next = lists.get(V).get(i);
            if ( !visited[next] ) {
                dfs(next, lists, visited, depth+1);
                visited[next] = false;
            }
        }
//        visited[V] = false;
        //
        // 반복문
        // 반복문 돌면서 방문 안했다면 방문..
    }
}