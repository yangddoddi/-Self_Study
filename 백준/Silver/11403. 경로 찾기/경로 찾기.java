import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] nodes = new int[N][N];
        addNodes(br, N, nodes);

        for (int k=0; k<nodes.length; k++) {
            for (int i=0; i<nodes.length; i++) {
                for (int j=0; j<nodes.length; j++) {
                    if (nodes[i][j] == 0 && nodes[i][k] == 1 && nodes[k][j] == 1) {
                        nodes[i][j] = 1;
                    }
                }
            }
        }

        for (int i=0; i<nodes.length; i++) {
            for (int j=0; j<nodes[i].length; j++) {
                System.out.print(nodes[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private static void addNodes(BufferedReader br, int N, int[][] nodes) throws IOException {
        for (int i = 0; i< N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j< N; j++) {
                nodes[i][j] = Integer.parseInt(input[j]);
            }
        }
    }
}
