package String;

public class calculatorForArgs {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("두개의 수와 원하는 사칙연산 기호를 작성해주세요.");
        } else {
            // 매개변수로 들어오는 모든 값은 String이기 때문에 원하는 타입으로 변경 필요
            int num1 = Integer.parseInt(args[0]);
            char code = args[1].charAt(0);
            int num2 = Integer.parseInt(args[2]);

            switch (code) {
                case '+' :
                    System.out.println(num1 + num2);
                case '-' :
                    System.out.println(num1 - num2);
                case '/' :
                    System.out.println(num1 / num2);
                case '*' :
                    System.out.println(num1 * num2);
                default:
                    System.out.println("지원하지 않는 연산입니다.");
            }
        }
    }
}
