import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int draw = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int userDraw = Integer.parseInt(br.readLine());
        int[] userCards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        cards = Arrays.stream(cards).sorted().toArray();

        for (int num : userCards) {
            sb.append(mySearch(cards,num)).append(" ");
        }

        System.out.println(sb);
    }

    public static int mySearch(int[] arr, int num) {

        int start = 0;
        int end = arr.length-1;
        int mid = 0;


        while ( start <= end ) {
            mid = (start+end)/2;
            if ( num == arr[mid] ) {
                return 1;
            } else if ( num > arr[mid] ) {
                start = mid+1;
            } else if ( num < arr[mid] ) {
                end = mid-1;
            }
        }
        return 0;
    }
}