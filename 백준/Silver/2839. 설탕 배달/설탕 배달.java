import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sugarBeDelivered = scanner.nextInt();
        int result = -1; // result가 input값과 같아지는 순간이 오지 않는다면 -1
        int smallSugar = 0;
        int bigSugar = 0;

        outer : for (int i=0; smallSugar<sugarBeDelivered; i++) {
            smallSugar = 3 * i;
            bigSugar = 0;
            for (int j=0; bigSugar<sugarBeDelivered; j++) {
                bigSugar = 5 * j;
                if ( smallSugar + bigSugar == sugarBeDelivered ) {
                    result = i + j;
                    break outer;
                }
            }
        }
        System.out.println(result);
    }
}