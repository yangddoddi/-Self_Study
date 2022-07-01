import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstInput = scanner.nextInt();
        int secondInput = scanner.nextInt();
        boolean[] numRange = new boolean[10001];

        numRange[0] = numRange[1] = true;

        for (int i=0; i*i< numRange.length; i++) {
            if (!numRange[i]) {
                for (int j=i*i; j< numRange.length; j += i) {
                    numRange[j] = true;
                }
            }
        }

        ArrayList<Integer> numArr = new ArrayList<>();
        int sum = 0;
        for (int i=firstInput; i<=secondInput; i++) {
            if (!numRange[i]) {
                numArr.add(i);
                sum += i;
            }
        }
        
        if (numArr.size() == 0) {
            System.out.println(-1);
        } else {
            int min = numArr.get(0);
            System.out.println(sum);
            System.out.println(min);
        }
    }
}