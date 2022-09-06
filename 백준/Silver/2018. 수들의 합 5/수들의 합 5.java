
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start_pointer = 0;
        int end_pointer = 0;
        int sum = 0;
        int count = 0;

        while ( start_pointer <= N ) {

            if ( sum == N ) {
                count++;
                sum += end_pointer;
                end_pointer++;
            }

            if ( sum < N ) {
                sum += end_pointer;
                end_pointer++;
            }

            if ( sum > N ) {
                sum -= start_pointer;
                start_pointer++;
            }
        }

        System.out.println(count);
    }
}