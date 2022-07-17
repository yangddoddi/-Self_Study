import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dwarfs[] = new int[9];

        for (int i=0; i<9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(dwarfs);
        int dwarfs_length = Arrays.stream(dwarfs).sum();


        outer : for (int i=0; i< dwarfs.length; i++) {
            for (int j=0; j< dwarfs.length; j++) {
                if ( i == j ) { continue; }
                int sum = dwarfs[i] + dwarfs[j];
                if ( dwarfs_length - sum == 100) {
                    dwarfs[i] = 0;
                    dwarfs[j] = 0;
                    break outer;
                }
            }
        }

        for (int n : dwarfs) {
            if ( n != 0 ) {
                System.out.println(n);
            }
        }
    }
}