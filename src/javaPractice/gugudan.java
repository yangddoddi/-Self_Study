package javaPractice;

import java.util.Scanner;

public class gugudan {
    final static int MAX_INPUT = 9;
    final static int MIN_INPUT = 2;
    public static void main(String[] args) {
        // 변수 선언
        Scanner scanner;
        int inputNum;

        // 객체 생성 및 값 대입
        System.out.print("[안내]희망하는 구구단을 숫자로 입력해 주세요 (2 ~ 9) : ");
        scanner = new Scanner(System.in);
        inputNum = scanner.nextInt();

        // 입력값이 올바르지 않을 경우 프로그램 종료
        checkInputValue(inputNum);

        // 결과 보여주기
        showResult(inputNum);

    }

    public static void checkInputValue(int num) {
        if ( num < MIN_INPUT || num > MAX_INPUT ) {
            System.out.println(num + " 단이 입력되었습니다.");
            System.out.println("[경고]구구단은 2단 ~ 9단 까지만 선택할 수 있습니다.");
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
    }

    public static void showResult(int num) {
        for ( int i=1; i<10; i++ ) {
            System.out.printf("%d * %d = %d%n", num, i, num*i);
        }
    }
}
