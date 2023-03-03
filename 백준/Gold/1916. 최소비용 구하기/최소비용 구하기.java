import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());

        List<List<int[]>> routes = new ArrayList<>();
        initializeRoutes(cityCount, routes);
        addRoutes(br, busCount, routes);

        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);

        int[] result = dijkstra(routes, start);
        System.out.println(result[target]);
    }

    private static int[] dijkstra(List<List<int[]>> list, int start) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] distArr = new int[list.size()];
        initializeDist(distArr);
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentCity = current[0];
            int currentDist = current[1];
            
            if (currentDist > distArr[currentCity]) continue;

            for (int i=0; i<list.get(currentCity).size(); i++) {
                int[] next = list.get(currentCity).get(i);
                int nextCity = next[0];
                int nextDist = next[1];

                if (currentDist + nextDist < distArr[nextCity]) {
                    distArr[nextCity] = currentDist + nextDist;
                    queue.add(new int[]{nextCity, currentDist + nextDist});
                }
            }
        }

        return distArr;
    }

    private static void initializeDist(int[] dist) {
        for (int i = 0; i< dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
    }

    private static void addRoutes(BufferedReader br, int busCount, List<List<int[]>> routes) throws IOException {
        for (int i = 0; i< busCount; i++) {
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int dist = Integer.parseInt(input[2]);

            routes.get(start).add(new int[]{end, dist});
        }
    }

    private static void initializeRoutes(int cityCount, List<List<int[]>> routes) {
        for (int i = 0; i<= cityCount; i++) {
            routes.add(new ArrayList<>());
        }
    }
}
