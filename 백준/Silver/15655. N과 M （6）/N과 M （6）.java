import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static List<Integer> digits = new ArrayList<>();
    private static boolean[] visited;
    private static int[] selective;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int countOfDigits = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        visited = new boolean[10001];
        selective = new int[target];

        input = br.readLine().split(" ");
        for (int i=0; i<countOfDigits; i++) {
            digits.add(Integer.parseInt(input[i]));
        }

        digits = digits
                .stream()
                .sorted((a, b) -> a-b)
                .collect(Collectors.toList());

        backtracking(0, 0, target);
    }

    private static void backtracking(int cnt, int current, int target) {
        if (cnt == target) {
            StringBuilder sb = new StringBuilder();

            for (int n : selective) {
                sb.append(n).append(" ");
            }

            System.out.println(sb.toString());
            return;
        }

        for (int d : digits) {
            if (d > current && !visited[d]) {
                selective[cnt] = d;
                backtracking(cnt+1, d, target);
                visited[d] = false;
            }
        }
    }
}