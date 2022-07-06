package javaPractice;
import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    System.out.println("===Java Calculator===");
    Scanner input = new Scanner(System.in);
        /*
            요구 사항에 따라 간단한 계산기를 만들어주세요.
            1. 사용자의 입력으로 첫 번째 숫자, 연산자, 두 번째 숫자를 받아야 합니다.
            2. 연산자의 종류는 +, -, *, / 입니다.
            3. 소수점 연산을 수행할 수 있어야 합니다.
            4. 연산 결과를 콘솔에 출력합니다.
        */
    // TODO...
    System.out.println("원하는 숫자를 입력해주세요");
    // 초기값, 연산 후에는 연산 결과가 초기값으로 쓰임
    double initialValue = Double.parseDouble(input.nextLine());
    // 연산 결과를 저장할 변수
    double temp = 0;
    for (;;) {
      System.out.println("원하는 연산 기호를 입력해주세요. ( + , - , / , * ) ");
      String inputSign = input.nextLine();
      System.out.println("원하는 숫자를 입력해주세요.");
      double inputNum = Double.parseDouble(input.nextLine());

      // 사칙 연산 기호 제외 다른 문자열이 들어올 경우 연산이 수행되지 않아 기존 초기값 이후 연산 기호 입력부터 다시 진행하게됨
      // 별도로 continue, break 처리는 해주지 않았음.
      switch (inputSign) {
        case "+" :
          temp = initialValue + inputNum;
          break;
        case "-" :
          temp = initialValue - inputNum;
          break;
        case "*" :
          temp = initialValue * inputNum;
          break;
        case "/" :
          temp = initialValue / inputNum;
          break;
        default:
          System.out.println("잘못된 연산 기호입니다.");
      }

      System.out.println( initialValue + inputSign + inputNum + " = " + temp);
      // 연산 결과를 초기값에 대입
      initialValue = temp;
      System.out.println( "현재 값 : " + initialValue );
      System.out.println( "현재 값에 이어서 연산을 원하시면 \"아무 키\"를 종료를 원하시면 \"2\"를 입력해주세요.");
      inputSign = input.nextLine();
      if (inputSign.equals("2")) { break ;}
    }
    }
}
