import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static List<Integer> digits = new ArrayList<>();
    private static int[] selective;
    private static StringBuilder sb = new StringBuilder();

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

        digits = digits
                .stream()
                .sorted((a, b) -> a-b)
                .collect(Collectors.toList());

        backtracking(0, target);
        
        System.out.println(sb.toString());
    }

    private static void backtracking(int cnt, int target) {
        if (cnt == target) {
            for (int n : selective) {
                sb.append(n).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int d : digits) {
            selective[cnt] = d;
            backtracking(cnt+1, target);
        }
    }
}