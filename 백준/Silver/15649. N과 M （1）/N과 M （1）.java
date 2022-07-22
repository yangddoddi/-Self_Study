import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class Main {

    public static boolean[] visited;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[M];

        backtracking(N,M,0);
    }


    static void backtracking(int N, int M, int depth) {
        if ( depth == M ) {
            for ( int n : arr ) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for (int i=0; i<N; i++) {
            if ( !visited[i] ) {
                visited[i] = true;
                arr[depth] = i+1;
                backtracking(N, M, depth+1);
                visited[i] = false;
            }
        }
    }
}