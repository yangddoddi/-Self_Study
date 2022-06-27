import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        T : for (int k=0; k<testCase; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int floor = Integer.parseInt(st.nextToken());
            int room = Integer.parseInt(st.nextToken());
            int client = Integer.parseInt(st.nextToken());
            int count = 1;

            for (int i = 1; i <= room; i++) {
                for (int j = 1; j <= floor; j++) {
                    if (count == client) {
                        sb.append((j * 100) + i).append('\n');
                        continue T;
                    }
                    count++;
                }
            }
        }

        System.out.println(sb);
    }
}