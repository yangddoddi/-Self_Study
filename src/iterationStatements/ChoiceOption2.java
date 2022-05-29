package iterationStatements;

import java.util.Scanner;

// whileStudy의 ChoiceOption에 기능 추가
// 제곱근, 제곱, 로그 구하기
public class ChoiceOption2 {
    public static void main(String[] args) {
        int menu = 0;
        int subMenu = 0;

        calculator : while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("원하는 메뉴를 선택해주세요.");
            System.out.println("1.제곱");
            System.out.println("2.제곱근");
            System.out.println("3.로그");
            System.out.println("4.종료");

            menu = Integer.parseInt(scanner.nextLine());

            if ( menu > 4 || menu < 1 ) {
                System.out.println("잘못 입력하셨습니다. 종료는 4번입니다.");
                continue;
            } else if ( menu == 4 ) {
                System.out.println("종료합니다.");
                break;
            }

            for (;;) { // == while (true)
                System.out.println("계산할 수를 입력하세요 (0: 계산 종료, 99: 프로그램 종료");
                Scanner scanner2 = new Scanner(System.in);
                subMenu = Integer.parseInt(scanner2.nextLine());

                if (subMenu == 0) break;
                if (subMenu == 99) break calculator;

                switch (menu) {
                    case 1 :
                        System.out.printf(" 값 : %d%n ",subMenu*subMenu);
                        break ;
                    case 2 :
                        System.out.printf(" 값 : %s%n ",Math.sqrt(subMenu));
                        break ;
                    case 3 :
                        System.out.printf(" 값 : %s%n ",Math.log(subMenu*subMenu));
                        break ;
                }
            }
        }
    }
}
