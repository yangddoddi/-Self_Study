import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<arr.length; i++) {
            int key = i;
            int value = arr[i];

            for (int j=i-1; j>=0; j--) {
                if (arr[j] < arr[i]) {
                    key = j+1;
                    break;
                }
                if (j==0) {
                    key=0;
                }
            }

            for (int j=i; j>key; j--) {
                arr[j] = arr[j-1];
            }

            arr[key] = value;
        }

        int[] temp = new int[arr.length+1];
        for (int i=1; i<arr.length+1; i++) {
            temp[i] = arr[i-1] + temp[i-1];
        }

        int answer = 0;
        for (int i=1; i<arr.length+1; i++) {
            answer += temp[i];
        }

        System.out.println(answer);
    }
}