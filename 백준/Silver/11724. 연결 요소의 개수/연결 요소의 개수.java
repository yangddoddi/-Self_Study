import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 방향이 없다.
        // 1번째 줄 정점 개수 N, 간선 개수 M
        // 두번째 줄부터 간선의 양 끝점 u, v
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        // 정점 개수 입력 받기
        // 간선 개수 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        // 반복문
        // 간선 정보 입력할 ArrayList 초기화 (정점 수만큼)
        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        // 반복문 (간선 수만큼)
        // -> 방향이 없기 때문에 각 정점은 서로 상대방의 값을 가진다.
        // -> 따라서 ArrayList.get(u).add(v), ArrayList.get(v).add(u)를 모두 해줘야함.
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            list.get(n).add(k);
            list.get(k).add(n);
        }

        // dfs실행 ( 원본 배열, 방문 체크용 배열, 정점 )
        boolean[] visited = new boolean[N+1];
        int answer = 0;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).isEmpty()) answer++;
            for (int j=0; j<list.get(i).size(); j++) {
                if (!visited[list.get(i).get(j)]) {
                    dfs(list.get(i).get(j), list, visited);
                    answer++;
                }
            }
        }

        // 정답 출력
        System.out.println(answer-1);
    }

    public static void dfs(int vertex, ArrayList<ArrayList<Integer>> arr, boolean[] visited) {
        if (visited[vertex]) return;

        // 호출 시 해당 정점은 방문했으므로 true
        visited[vertex] = true;

        // 해당 정점에 등록된 간선 조회
        for (int i = 0; i < arr.get(vertex).size(); i++) {
            int next = arr.get(vertex).get(i);

            // 만약 간선으로 통하는 정점을 아직 방문하지 않았다면 재귀호출
            if (!visited[next]) {
                dfs(next, arr, visited);
            }

        }
    }
}
