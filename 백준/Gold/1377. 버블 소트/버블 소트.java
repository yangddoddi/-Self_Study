import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Temp[] arr = new Temp[N];
        for (int i=0; i<N; i++) {
            arr[i] = new Temp(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(arr);
        int max = 0;

        for (int i=0; i<N; i++) {
            if ( i != arr[i].getIndex() ) {
                max = Math.max( arr[i].getIndex() - i, max );
            }
        }

        System.out.println(max + 1);
    }
}

class Temp implements Comparable<Temp> {
    private final int index;
    private final int value;

    public Temp(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Temp o) {
        return this.value - o.value;
    }

    public int getIndex() {
        return this.index;
    }

    public int getValue() {
        return this.value;
    }
}