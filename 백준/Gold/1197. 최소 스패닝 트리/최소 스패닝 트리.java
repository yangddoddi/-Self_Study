import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int countOfVertex = Integer.parseInt(input[0]);
        int countOfEdges = Integer.parseInt(input[1]);

        int[] parents = new int[countOfVertex+1];
        initializeParents(parents);

        List<int[]> edges = new ArrayList<>();
        addEdges(br, countOfEdges, edges);
        edges = sortEdges(edges);

        int answer = 0;
        for (int[] edge : edges) {
            if (find(edge[0], parents) != find(edge[1], parents)) {
                union(edge[0], edge[1], parents);
                answer += edge[2];
            }
        }

        System.out.println(answer);
    }

    private static List<int[]> sortEdges(List<int[]> edges) {
        return edges.stream()
                .sorted(Comparator.comparingInt(a -> a[2]))
                .collect(Collectors.toList());
    }

    private static void initializeParents(int[] parents) {
        for (int i = 0; i< parents.length; i++) {
            parents[i] = i;
        }
    }

    private static void addEdges(BufferedReader br, int countOfEdges, List<int[]> edges) throws IOException {
        String[] input;
        for (int i = 0; i< countOfEdges; i++) {
            input = br.readLine().split(" ");

            int nodeA = Integer.parseInt(input[0]);
            int nodeB = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            edges.add(new int[]{nodeA, nodeB, weight});
        }
    }

    private static void union(int nodeA, int nodeB, int[] parents) {
        int parentA = parents[nodeA];
        int parentB = parents[nodeB];

        if (parentA < parentB) {
            parents[parentB] = parentA;
        } else {
            parents[parentA] = parentB;
        }
    }

    private static int find(int node, int[] parents) {
        if (node == parents[node]) return node;

        return parents[node] = find(parents[node], parents);
    }
}
