import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int count = 0;

        while ( sum(count) < input ) {
            count++;
        }
        int difference = sum(count)-input;
        int numerator = 0;
        int denominator = 0;

        if (count%2!=0) {
            numerator = (count-1)-difference;
            denominator = 1+difference;
        } else {
            numerator = 1+difference;
            denominator = (count-1)-difference;
        }

        String result = numerator + "/" + denominator;
        System.out.println(result);
    }

    public static int sum(int count) {
        return ( count * ( count - 1 ) ) / 2;
    }
}