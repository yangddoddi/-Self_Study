import java.io.*;
import java.util.*;

public class Main {
    private static int answer = 0;
    private static int target;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        int countOfDigits = Integer.parseInt(input[0]);
        target = Integer.parseInt(input[1]);

        int[] digits = new int[countOfDigits];
        input = bufferedReader.readLine().split(" ");

        for (int i=0; i<digits.length; i++) {
            digits[i] = Integer.parseInt(input[i]);
        }

        backtracking(digits, 0, 0);
        System.out.println((target == 0) ? answer-1 : answer);
    }

    private static void backtracking(int[] digits, int depth, int sum) {
        if (depth == digits.length) {
            if (sum == target) {
                answer++;
            }

            return;
        }

        backtracking(digits, depth+1, sum + digits[depth]);
        backtracking(digits, depth+1, sum);
    }
}