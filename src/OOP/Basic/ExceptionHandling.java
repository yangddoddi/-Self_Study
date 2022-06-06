package OOP.Basic;

public class ExceptionHandling {
    public static void main(String[] args) {
        int num = 100;
        int result = 0;

        for ( int i=0; i < 10; i++ ) {
            int randomNum = (int)(Math.random()*10);
            try {
                result = num / randomNum;
            } catch (ArithmeticException e) {
                System.out.println("0");
            } // 자바에서 정수를 0으로 나누는 것은 허용되지 않기 때문에 ArithmeticExeption을 발생시킨다.
            // 따라서 이 경우 0을 출력하는 것으로 예외 처리를 함으로써 예외처리.
            System.out.println(result);
        }
    }
}
