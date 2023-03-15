import java.io.*;
import java.util.*;

public class Main {
    private static int max;
    private static int countOfDigits;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        max = Integer.parseInt(input[0]);
        countOfDigits = Integer.parseInt(input[1]);

        dfs(new int[countOfDigits], 0, 1);
    }

    private static void dfs(int[] arr, int cnt, int current) {
        if (cnt == countOfDigits) {
            StringBuilder builder = new StringBuilder();
            for (int a : arr) {
                builder.append(a).append(" ");
            }
            System.out.println(builder.toString());
            return;
        }

        for (int i=current; i<=max; i++) {
            arr[cnt] = i;
            dfs(arr, cnt+1, i);
        }
    }
}