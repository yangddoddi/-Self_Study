import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int[] vertex;
    public static int order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] userInput = br.readLine().split(" ");
        int n = Integer.parseInt(userInput[0]);
        int edge = Integer.parseInt(userInput[1]);
        int startVertex = Integer.parseInt(userInput[2])-1;
        visited = new boolean[n];

        for ( int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for ( int i=0; i<edge; i++ ) {
            userInput = br.readLine().split(" ");
            int num1 = Integer.parseInt(userInput[0])-1;
            int num2 = Integer.parseInt(userInput[1])-1;
            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }

        for ( int i=0; i<n; i++ ) {
            Collections.sort(graph.get(i));
        }

        order = 1;
        vertex = new int[n];
        dfs(startVertex);

        for ( int num : vertex ) {
            System.out.println(num);
        }
    }

    public static void dfs(int R){
            visited[R] = true;
            vertex[R] = order++;

            for (int v : graph.get(R)) {
                if (!visited[v]) {
                    dfs(v);
                }
            }
        }
    }