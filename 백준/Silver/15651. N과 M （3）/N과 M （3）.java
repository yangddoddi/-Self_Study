import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static final int MIN_VALUE = 1;
    static StringBuilder sb = new StringBuilder();
    static int numRange = 0;
    static int numberPick = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        numRange = Integer.parseInt(st.nextToken());
        numberPick = Integer.parseInt(st.nextToken());
        ArrayList<Integer> temp = new ArrayList<>();

        backTracking(1, temp);
        System.out.println(sb.toString());
    }

    public static void backTracking(int num, ArrayList<Integer> temp) {
        if ( temp.size() == numberPick ) {
            for ( int n : temp ) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=MIN_VALUE; i<=numRange; i++) {
            temp.add(i);
            backTracking(i,temp);
            temp.remove(temp.size()-1);
        }
    }
}
