import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int countOfVertex = Integer.parseInt(input[0]);
        int countOfEdge = Integer.parseInt(input[1]);
        int startVertex = Integer.parseInt(br.readLine());

        List<List<int[]>> list = new ArrayList<>();
        initializeList(countOfVertex, list);

        for (int i=0; i<countOfEdge; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            list.get(u).add(new int[]{v, w});
        }

        int[] distArr = dijkstra(list, startVertex);
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<distArr.length; i++) {
            int dist = distArr[i];

            sb.append((dist == Integer.MAX_VALUE) ? "INF" : dist).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void initializeList(int countOfVertex, List<List<int[]>> list) {
        for (int i = 0; i< countOfVertex +1; i++) {
            list.add(new ArrayList<>());
        }
    }

    private static int[] dijkstra(List<List<int[]>> list, int start) {
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int[] dist = new int[list.size()];
        queue.add(new int[]{start, 0});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i=0; i<list.get(current[0]).size(); i++) {
                int[] next = list.get(current[0]).get(i);
                int weight = next[1];
                int nextNode = next[0];
                int nextDist = weight + current[1];

                if (nextDist > dist[nextNode]) continue;

                dist[nextNode] = nextDist;
                queue.add(new int[]{nextNode, nextDist});
            }
        }

        return dist;
    }
}
