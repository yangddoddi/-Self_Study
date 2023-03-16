import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());

        // G?
        // 성원이의 현재 몸무게^2 - 기억하고 있던 몸무게^2
        // G = n^2 - m^2

        int prev = 1;
        int current = 1;
        StringBuilder sb = new StringBuilder();
        while (current < 100000) {
            long prev2 = (long) prev * prev;
            long current2 = (long) current * current;
            long temp = current2 - prev2;

            if (temp == G) sb.append(current).append("\n");

            if (temp <= G) current++;

            if (temp > G) prev++;
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb.toString());
        }
    }
}