import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static LinkedList<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static boolean[] visited;
    static boolean[] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 정점 수, 간선 수, 시작점
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        // 시작점이 1이므로 <=으로 반복문을 돌린다.
        for (int i=0; i<=V; i++) {
            edges.add(new ArrayList<>());
        }

        // 무방향(양방향) 그래프이다.
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int edge1 = Integer.parseInt(st.nextToken());
            int edge2 = Integer.parseInt(st.nextToken());

            edges.get(edge1).add(edge2);
            edges.get(edge2).add(edge1);

        }

        // 오름차순으로 방문한다
        for (int i=0; i<=V; i++) {
            Collections.sort(edges.get(i));
        }

        // 시작 정점이 1이므로 +1
        visited = new boolean[V+1];
        checked = new boolean[V+1];

        dfs(S);
        sb.append("\n");
        bfs(S);

        System.out.println(sb.toString());
    }

    public static void dfs(int v) {
        visited[v] = true;
        sb.append(String.valueOf(v)).append(" ");

        for (int n : edges.get(v)) {
            if ( !visited[n] ) {
                dfs(n);
            }
        }
    }

    public static void bfs(int v) {
        queue.add(v);
        checked[v] = true;
        while ( !queue.isEmpty() ) {
            // 현재 노드 - 큐의 가장 앞에 있는 노드
            int current = queue.poll();
            sb.append(current).append(" ");
            for (int n : edges.get(current)) {
                if (!checked[n]) {
                    queue.add(n);
                    checked[n]=true;
                }
            }
        }
    }
}