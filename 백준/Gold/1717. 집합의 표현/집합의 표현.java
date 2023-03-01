import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] parents = new int[N+1];

        for (int i=1; i<=N; i++) {
            parents[i] = i;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int bit = Integer.parseInt(input[0]);
            int nodeA = Integer.parseInt(input[1]);
            int nodeB = Integer.parseInt(input[2]);

            if (bit == 0) {
                union(nodeA, nodeB, parents);
            }

            if (bit == 1) {
                Boolean isSame = checkSame(nodeA, nodeB, parents);

                stringBuilder.append((isSame) ? "YES" : "NO").append("\n");
            }
        }

        System.out.println(stringBuilder.toString());
    }

    private static int find(int node, int[] parents) {
        if (node == parents[node]) {
            return node;
        } else {
            return parents[node] = find(parents[node], parents);
        }
    }

    private static void union(int nodeA, int nodeB, int[] parents) {
        int parentA = find(nodeA, parents);
        int parentB = find(nodeB, parents);

        if (parentA != parentB) {
            if (parentA < parentB) {
                parents[parentB] = parentA;
            } else {
                parents[parentA] = parentB;
            }
        }
    }

    private static Boolean checkSame(int nodeA, int nodeB, int[] parents) {
        int parentA = find(nodeA, parents);
        int parentB = find(nodeB, parents);

        return parentA == parentB;
    }
}
