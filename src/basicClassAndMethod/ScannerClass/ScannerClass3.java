package basicClassAndMethod.ScannerClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerClass3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("ScannerStudy2.txt")); // 라인을 스캔하는 역할
        int totalSum = 0;
        int cnt = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Scanner sc2 = new Scanner(line).useDelimiter(","); // sc를 구분자로 나눠서 스캔함
            int lineSum =0;
            while(sc2.hasNextInt()) {
                lineSum += sc2.nextInt();
                cnt++;
            }
            System.out.println(line + " = " + lineSum);
            totalSum += lineSum;
        }
        System.out.println("총합 = " + totalSum);
        System.out.println("평균 = " + totalSum/cnt);
        System.out.println("데이타 수 = " + cnt);
    }
}