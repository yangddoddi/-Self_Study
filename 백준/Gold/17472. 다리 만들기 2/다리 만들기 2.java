import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {
    private static boolean[][] visited;
    private static List<int[]> routes = new ArrayList<>();
    private static int countOfIsland = 1;
    private static int[] moveColumn = new int[]{1, -1, 0, 0};
    private static int[] moveRow = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int row = Integer.parseInt(input[0]);
        int column = Integer.parseInt(input[1]);
        int[] parents;

        int[][] map = new int[row][column];
        visited = new boolean[row][column];
        initializeMap(br, map);
        getIslands(map);

        parents = new int[countOfIsland];
        initializeParents(parents);

        getColumnRoutes(map);
        getRowRoutes(map);

        routes = routes.stream()
                .sorted((a, b) -> a[2] - b[2])
                .collect(Collectors.toList());

        int answer = 0;
        for (int[] route : routes) {
            if (find(route[0], parents) != find(route[1], parents)) {
                union(route[0], route[1], parents);
                answer += route[2];
            }
        }

        for (int i=2; i<countOfIsland; i++) {
            if (find(1, parents) != find(i, parents)) {
                System.out.println(-1);
                System.exit(0);
            }
        }

        System.out.println(answer);
    }

    private static void getRowRoutes(int[][] map) {
        for (int i = 0; i< map[0].length; i++) {
            int prev = 0;
            int weight = 0;

            for (int j = 0; j< map.length; j++) {
                if (map[j][i] == 0 && prev == 0) continue;

                if (map[j][i] == 0 && prev != 0) {
                    weight++;
                    continue;
                }

                if (map[j][i] != 0 && prev == 0) {
                    prev = map[j][i];
                    continue;
                }

                if (map[j][i] == prev) {
                    weight = 0;
                    continue;
                }

                if (map[j][i] != 0 && map[j][i] != prev) {
                    if (weight > 1) {
                        routes.add(new int[]{prev, map[j][i], weight});
                    }
                    weight = 0;
                    prev = map[j][i];
                }
            }
        }
    }

    private static void getColumnRoutes(int[][] map) {
        for (int i = 0; i< map.length; i++) {
            int prev = 0;
            int weight = 0;

            for (int j = 0; j< map[i].length; j++) {
                if (map[i][j] == 0 && prev == 0) continue;

                if (map[i][j] == 0 && prev != 0) {
                    weight++;
                    continue;
                }

                if (map[i][j] != 0 && prev == 0) {
                    prev = map[i][j];
                    continue;
                }

                if (map[i][j] == prev) {
                    weight = 0;
                    continue;
                }

                if (map[i][j] != 0 && map[i][j] != prev) {
                    if (weight > 1) {
                        routes.add(new int[]{prev, map[i][j], weight});
                    }
                    weight = 0;
                    prev = map[i][j];
                }
            }
        }
    }

    private static void initializeParents(int[] parents) {
        for (int i = 0; i< parents.length; i++) {
            parents[i] = i;
        }
    }

    private static void getIslands(int[][] map) {
        for (int i = 0; i< map.length; i++) {
            for (int j = 0; j< map[i].length; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    bfs(map, i, j);
                    countOfIsland++;
                }
            }
        }
    }

    private static void bfs(int[][] map, int row, int column) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, column});
        map[row][column] = countOfIsland;
        visited[row][column] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i< moveColumn.length; i++) {
                int nextColumn = current[1] + moveColumn[i];
                int nextRow = current[0] + moveRow[i];

                if (nextColumn < 0 || nextRow < 0 || nextColumn >= map[0].length || nextRow >= map.length) {
                    continue;
                }

                if (visited[nextRow][nextColumn] || map[nextRow][nextColumn] == 0) {
                    continue;
                }

                visited[nextRow][nextColumn] = true;
                map[nextRow][nextColumn] = countOfIsland;
                queue.add(new int[]{nextRow, nextColumn});
            }
        }
    }

    private static void initializeMap(BufferedReader br, int[][] map) throws IOException {
        String[] input;
        for (int i = 0; i< map.length; i++) {
            input = br.readLine().split(" ");

            for (int j = 0; j< map[i].length; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    private static void union(int islandA, int islandB, int[] parents) {
        int parentA = find(islandA, parents);
        int parentB = find(islandB, parents);

        if (parentA < parentB) {
            parents[parentB] = parentA;
        } else {
            parents[parentA] = parentB;
        }
    }

    private static int find(int island, int[] parents) {
        if (island == parents[island]) return island;

        return parents[island] = find(parents[island], parents);
    }
}
