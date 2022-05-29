package whileStudy;

import java.util.Scanner;

// 입력한 모든 값을 더한 결과 출력하기
public class AddInputNumbers {
    public static void main(String[] args) {
        boolean isTrue = true;
        int num = 0;
        int sum = 0;

        while(isTrue) {
            System.out.println("원하는 수를 입력해주세요. 종료를 원하시면 0을 입력해주세요.");
            Scanner scanner = new Scanner(System.in);
            num = Integer.parseInt(scanner.nextLine());

            if (num != 0) {
            sum += num;
            System.out.printf("입력 값은 %d입니다.%n",num);} else {
                System.out.println("계산을 종료합니다.");
                isTrue = false;
            }
        }
        System.out.printf("입력하신 값의 총합은 %d 입니다.",sum);
    }
}
