package standardOfJava.While;

import java.util.Scanner;

// continue와 break을 활용한 옵션 선택 예제
public class ChoiceOption {
    public static void main(String[] args) {
        int menu = 0;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("원하는 메뉴를 선택해주세요.");
            System.out.println("1.실행");
            System.out.println("2.옵션");
            System.out.println("3.도움말");
            System.out.println("4.종료");

            menu = Integer.parseInt(scanner.nextLine());

            if ( menu > 4 || menu < 1 ) {
                System.out.println("잘못 입력하셨습니다. 종료는 4번입니다.");
                continue;
            } else if ( menu == 4 ) {
                System.out.println("종료합니다.");
                break;
            }

            System.out.printf("선택하신 메뉴는 %d번 입니다.", menu);
        }
    }
}
