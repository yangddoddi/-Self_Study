import java.util.Scanner;

// 입력 값의 각 자리수를 더하는 계산기
public class AddEachDigit {
    public static void main(String[] args) {
        System.out.println("원하는 수를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String inputVal = scanner.nextLine();
        int userNum = Integer.parseInt(inputVal);
        int sum = 0;
        int total = 0;
        int i = 1;
        while (userNum != 0) {
            sum = userNum%10;
            total += sum;
            userNum = userNum/10;
            System.out.printf("%s의 자리는 %s%n",i,sum);
            i*=10;
        }
        System.out.printf("각 자리 수의 합은 %d입니다.",total);
    }
}
