import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int cityCount = Integer.parseInt(input[0]);
        int routeCount = Integer.parseInt(input[1]);
        int target = Integer.parseInt(input[2]);

        List<List<Node>> routes = new ArrayList<>();
        initializeRoutes(routes, cityCount);
        addRoutes(br, routeCount, routes);

        Queue<Integer>[] result = dijkstra(routes, target);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=1; i<=cityCount; i++) {
            if (result[i].size() < target) {
                stringBuilder.append(-1).append("\n");
                continue;
            }

            stringBuilder.append(result[i].poll()).append("\n");
        }

        System.out.println(stringBuilder.toString());
    }

    private static Queue<Integer>[] dijkstra(List<List<Node>> routes, int sizeLimit) {
        Queue<Node> queue = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        Queue<Integer>[] distArr = new Queue[routes.size()];
        initializeDistArr(distArr);
        queue.add(new Node(1, 0));
        distArr[1].add(0);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentDist = currentNode.dist;
            int currentCity = currentNode.to;

            for (int i=0; i<routes.get(currentCity).size(); i++) {
                Node nextNode = routes.get(currentCity).get(i);
                int nextDist = nextNode.dist;
                int nextCity = nextNode.to;

                if (distArr[nextCity].size() < sizeLimit) {
                    queue.add(new Node(nextCity, nextDist + currentDist));
                    distArr[nextCity].add(nextDist + currentDist);
                } else if (distArr[nextCity].peek() > nextDist + currentDist) {
                    distArr[nextCity].poll();
                    queue.add(new Node(nextCity, nextDist + currentDist));
                    distArr[nextCity].add(nextDist + currentDist);
                }
            }
        }

        return distArr;
    }

    private static void initializeDistArr(Queue<Integer>[] distArr) {
        for (int i = 0; i< distArr.length; i++) {
            distArr[i] = new PriorityQueue<>((a,b) -> b-a);
        }
    }

    private static void addRoutes(BufferedReader br, int routeCount, List<List<Node>> routes) throws IOException {
        String[] input;
        for (int i = 0; i< routeCount; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int dist = Integer.parseInt(input[2]);

            routes.get(start).add(new Node(to, dist));
        }
    }

    private static void initializeRoutes(List<List<Node>> routes, int size) {
        for (int i=0; i<=size; i++) {
            routes.add(new ArrayList<>());
        }
    }

    static class Node {
        int to;
        int dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
}
