package standardOfJava.basicClassAndMethod.ScannerClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerClass2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("ScannerStudy.txt"));
        int sum = 0;
        int cnt = 0;

        while (scanner.hasNextInt()) {
            sum += scanner.nextInt();
            cnt += 1;
        }

        System.out.println("총합 : " + sum);
        System.out.println("평균 : " + sum/cnt);
    }
}
