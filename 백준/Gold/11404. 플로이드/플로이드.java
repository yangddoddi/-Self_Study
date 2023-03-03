import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(br.readLine());
        int routeCount = Integer.parseInt(br.readLine());

        int[][] routes = new int[cityCount+1][cityCount+1];
        initializeRoutes(routes);

        for (int i=0; i<routeCount; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            if (routes[start][end] > weight) {
                routes[start][end] = weight;
            }
        }

        for (int k=1; k<=cityCount; k++) {
            for (int i=1; i<=cityCount; i++) {
                for (int j=1; j<=cityCount; j++) {
                    if (routes[i][k] != Integer.MAX_VALUE && routes[k][j] != Integer.MAX_VALUE) {
                        routes[i][j] = Math.min(routes[i][j], routes[i][k] + routes[k][j]);
                    }
                }
            }
        }

        for (int i=1; i<=cityCount; i++) {
            for (int j=1; j<=cityCount; j++) {
                int n = (routes[i][j] == Integer.MAX_VALUE) ? 0 : routes[i][j];
                System.out.print(n + " ");
            }
            System.out.print("\n");
        }
    }

    private static void initializeRoutes(int[][] routes) {
        for (int i = 0; i< routes.length; i++) {
            for (int j = 0; j< routes.length; j++) {
                if (i==j) {
                    routes[i][j] = 0;
                } else {
                    routes[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }
}
