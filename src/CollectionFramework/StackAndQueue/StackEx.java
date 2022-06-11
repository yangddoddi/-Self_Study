package CollectionFramework.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class StackEx {
    public static Stack<String> back = new Stack<>();
    public static Stack<String> forward = new Stack<>();
    public static void main(String[] args) {
        back.push("네이버");
        back.push("다음");
        back.push("쿠팡");
        back.push("카카오");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printStatus();
            System.out.printf("원하는 메뉴를 숫자로 입력해주세요.%n1.원하는 URL입력%n2.뒤로%n3.앞으로%n");
            int input = scanner.nextInt();
            switch (input) {
                case 1 :
                    System.out.println("원하는 URL을 입력해주세요");
                    Scanner scanner2 = new Scanner(System.in);
                    String inputURL = scanner2.nextLine();
                    goURL(inputURL);
                    break;
                case 2 :
                    goBack();
                    break;
                case 3 :
                    goForward();
            }
        }
    }

    public static void printStatus () {
        System.out.println("====================");
        System.out.println("back : " + back);
        System.out.println("foward : " + forward);
        System.out.println("===================");
    }

    public static void goURL(String url) {
        back.push(url);
        if(!forward.empty()) { forward.clear(); }
    }

    public static void goBack() {
        if(!back.empty()) {
            forward.push(back.pop());
            System.out.println("뒤로 이동!");
        }
    }

    public static void goForward() {
        if(!forward.empty()) {
            back.push(forward.pop());
        }
    }
}
