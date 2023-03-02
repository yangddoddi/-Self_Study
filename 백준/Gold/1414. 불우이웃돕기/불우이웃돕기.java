import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countOfComputers = Integer.parseInt(br.readLine());
        int[] parents = new int[countOfComputers];

        initializeParents(parents);
        initializeLan();

        List<int[]> lanList = new ArrayList<>();
        getLan(br, countOfComputers, lanList);
        lanList = sortLan(lanList);

        int totalOfLan = 0;
        for (int[] l : lanList) {
            totalOfLan += l[2];
        }

        for (int[] l : lanList) {
            if (find(l[0], parents) != find(l[1], parents)) {
                union(l[0], l[1], parents);
                totalOfLan -= l[2];
            }
        }

        int firstNetwork = 0;
        for (int i=1; i<parents.length; i++) {
            if (find(firstNetwork, parents) != find(i, parents)) {
                System.out.println(-1);
                System.exit(0);
            }
        }

        System.out.println(totalOfLan);
    }

    private static List<int[]> sortLan(List<int[]> lans) {
        return lans.stream()
                .sorted((a,b) -> a[2] - b[2])
                .collect(Collectors.toList());
    }

    private static void getLan(BufferedReader br, int countOfComputers, List<int[]> lans) throws IOException {
        for (int i = 0; i< countOfComputers; i++) {
            String input = br.readLine();

            for (int j = 0; j< countOfComputers; j++) {
                if (input.charAt(j) != '0') {
                    lans.add(new int[]{i, j, map.get(String.valueOf(input.charAt(j)))});
                }
            }
        }
    }

    private static void initializeLan() {
        for (int i=0; i<26; i++) {
            map.put(String.valueOf((char)('a'+i)), i+1);
        }

        for (int i=0; i<26; i++) {
            map.put(String.valueOf((char)('A'+i)), i+27);
        }
    }

    private static void initializeParents(int[] parents) {
        for (int i = 0; i< parents.length; i++) {
            parents[i] = i;
        }
    }

    private static int find(int lan, int[] parents) {
        if (lan == parents[lan]) return lan;

        return parents[lan] = find(parents[lan], parents);
    }

    private static void union(int lanA, int lanB, int[] parent) {
        int parentA = parent[lanA];
        int parentB = parent[lanB];

        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }
}
