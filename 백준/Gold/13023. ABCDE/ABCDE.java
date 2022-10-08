import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // A,B,C,D,E가 한 번에 이어지는 경우를 찾아야 한다 -> DFS
        // 깊이가 5면 정답 처리하면 될 듯
        // 사람 수(정점)은 일반 그래프와 달리 0부터 순서대로 주어지니 주의하자

        // 총 정점 수 N과 간선 M 입력받기.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 반복문
        // 인접 리스트를 위해 ArrayList N번 만큼 생성
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i=0; i<N; i++) {
            lists.add(new ArrayList());
        }

        // 반복문
        // // M번 반복하며 간선 정보 입력받기
        // // 친구 관계는 무방향이므로 양쪽에 동일하게 넣어주자.
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            lists.get(num1).add(num2);
            lists.get(num2).add(num1);
        }

        // 방문 여부 체크를 위한 배열 생성
        boolean[] visited = new boolean[N];
        // depth 체크용 변수 생성
        int depth = 0; // 별 의미는 없다.
        // 반복문

        // // 각 노드를 dfs로 탐색
        // // dfs (정점, 인접리스트, 방문여부체크, 깊이체크)
        for (int i=0; i<N; i++) {
            dfs(i, lists, visited, depth);
            Arrays.fill(visited, false);
        }

        System.out.println(0);
    }

    // dfs (정점, 인접리스트, 방문여부체크, 깊이체크)
    public static void dfs(int vertex, ArrayList<ArrayList<Integer>> lists, boolean[] visited, int depth) {
        // 만약 depth == 5라면 1 출력하고 시스템 종료
        if (depth == 4) {
            System.out.println(1);
            System.exit(0);
        }
        // 만약 방문했었다면 리턴
        // visited[정점] = true
//        if (visited[vertex]) return;
        visited[vertex] = true;
        // 반복문 (list.size)
        for (int i=0; i<lists.get(vertex).size(); i++) {
            int next = lists.get(vertex).get(i);
            if (!visited[next]) {
//                visited[next] = true;
                dfs(next, lists, visited, depth + 1);
                visited[next] = false;
            }
        }
        // if !isited[정점] 라면 dfs
    }
}