import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static List<Integer> digits = new ArrayList<>();
    private static int[] selective;
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visited = new boolean[10001];
    private static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int countOfDigits = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        selective = new int[target];

        input = br.readLine().split(" ");
        for (int i=0; i<countOfDigits; i++) {
            digits.add(Integer.parseInt(input[i]));
        }

        digits = digits.stream()
                .sorted((a, b) -> a - b)
                .collect(Collectors.toList());

        backtracking(0, 0, target);

        set.forEach(e -> System.out.println(e));
    }

    private static void backtracking(int cnt, int current, int target) {
        if (cnt == target) {
            for (int n : selective) {
                sb.append(n).append(" ");
            }

            set.add(sb.toString());
            sb.delete(0, sb.length());
            return;
        }

        for (int i=0; i<digits.size(); i++) {
            if (!visited[i] && current <= digits.get(i)) {
                visited[i] = true;
                selective[cnt] = digits.get(i);
                backtracking(cnt + 1, digits.get(i), target);
                visited[i] = false;
            }
        }
    }
}