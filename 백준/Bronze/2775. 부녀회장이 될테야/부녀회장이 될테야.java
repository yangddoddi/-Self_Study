import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        int[][] resultArr = new int[15][15];


        for (int i=0; i<T; i++) {
            int inputFloor = scanner.nextInt();
            int inputRoom = scanner.nextInt();

            for (int k=0; k<resultArr.length; k++) {
                for (int j=1; j< resultArr.length; j++) {
                    if (k==0) { resultArr[k][j] = j; }
                    else if (j==1) { resultArr[k][j] = 1; }
                    else { resultArr[k][j] = resultArr[k-1][j] + resultArr[k][j-1]; }
                }
            }

            System.out.println(resultArr[inputFloor][inputRoom]);
        }
    }
}