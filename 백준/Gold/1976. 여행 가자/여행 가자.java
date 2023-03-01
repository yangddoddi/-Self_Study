import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countOfCities = Integer.parseInt(br.readLine());
        int countOfData = Integer.parseInt(br.readLine());

        int[] parents = initializeParents(countOfCities);

        getUnion(br, countOfData, parents, countOfCities);
        validateRoute(br, parents);

        System.out.println("YES");
    }

    private static void validateRoute(BufferedReader br, int[] parents) throws IOException {
        int prev = Integer.MAX_VALUE;
        String[] input = br.readLine().split(" ");
        for (String s : input) {
            int parent = find(Integer.parseInt(s), parents);

            if (prev == Integer.MAX_VALUE) {
                prev = parent;
            } else if (prev != parent) {
                System.out.println("NO");
                System.exit(0);
            }
        }
    }

    private static void getUnion(BufferedReader br, int countOfData, int[] parents, int countOfCities) throws IOException {
        for (int i = 0; i < countOfCities; i++) {
            String[] input = br.readLine().split(" ");

            for (int j=0; j<input.length; j++) {
                if (Integer.parseInt(input[j]) == 1) {
                    union(i+1, j+1, parents);
                }
            }
        }
    }

    private static int[] initializeParents(int cities) {
        int[] parents = new int[cities+1];
        for (int i=0; i<parents.length; i++) {
            parents[i] = i;
        }
        return parents;
    }

    private static void union(int cityA, int cityB, int[] parents) {
        int parentA = find(cityA, parents);
        int parentB = find(cityB, parents);

        if (parentA != parentB) {
            if (parentA < parentB) {
                parents[parentB] = parentA;
            } else {
                parents[parentA] = parentB;
            }
        }
    }

    private static int find(int city, int[] parents) {
        if (parents[city] == city) return city;

        return find(parents[city], parents);
    }
}
