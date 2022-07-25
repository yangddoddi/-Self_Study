import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] order;
    static int count=0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        for (int i=0; i<=vertex; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i=1; i<=edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }

        for (int i=1; i<=vertex; i++) {
            Collections.sort(graph.get(i));
            Collections.reverse(graph.get(i));
        }

        visited = new boolean[vertex+1];
        order = new int[vertex+1];

        dfs(start);

        for (int i=1; i< order.length; i++) {
            System.out.println(order[i]);
        }
    }

    static void dfs(int v) {
        count++;
        visited[v] = true;
        order[v] = count;

        for (int a : graph.get(v)) {
            if (!visited[a]) {
                dfs(a);
            }
        }
    }
}