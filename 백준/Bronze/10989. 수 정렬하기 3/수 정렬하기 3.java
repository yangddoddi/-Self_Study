import java.io.BufferedReader;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];

        for (int i=0; i<T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int[] resultArr = new int[max+1];

        for (int i=0; i<arr.length; i++) {
            resultArr[arr[i]]++;
        }

        for (int i=0; i< resultArr.length; i++) {
            if ( resultArr[i] != 0 ) {
                for (int k=0; k<resultArr[i]; k++) {
                    sb.append(i).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}