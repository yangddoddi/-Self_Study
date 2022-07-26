import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int[] order;
    static int count = 0;
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        for (int i=0; i<=vertex; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            edges.get(num1).add(num2);
            edges.get(num2).add(num1);
        }

        for (ArrayList<Integer> list : edges) {
            Collections.sort(list);
        }

        visited = new boolean[vertex+1];
        order = new int[vertex+1];

        bfs(start);

        for (int i=1; i< order.length; i++) {
            System.out.println(order[i]);
        }
    }

    static void bfs (int v) {
        visited[v] = true;
        order[v] = ++count;
        queue.add(v);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for ( int i=0; i< edges.get(current).size(); i++) {
                int x = edges.get(current).get(i);
                if (!visited[x]) {
                    visited[x] = true;
                    order[x] = ++count;
                    queue.add(x);
                }
            }
        }
    }
}