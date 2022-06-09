package basicClassAndMethod.ScannerClass;

import java.util.Scanner;

public class ScannerClass {
    public static void main(String[] args) {
        final String prompt = ">>";
        String[] strArr = null;
        System.out.println("q를 누르면 종료됩니다.");

        for (;;) {
            System.out.print(prompt);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            input = input.trim(); // 좌우 공백 제거;
            strArr = input.split(" +"); // 공백이 한 칸 이상 있을 경우 구분자로 삼아 배열로 나눈다.
            if (strArr[0].equals("")) continue; // 공백밖에 없다면..
            if (strArr[0].equals("q")) { System.exit(0); }
            for (int i=0; i< strArr.length; i++) {
                System.out.println(strArr[i]);
            }
        }
        }
    }
