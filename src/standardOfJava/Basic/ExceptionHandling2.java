package standardOfJava.Basic;

public class ExceptionHandling2 {
    public static void main(String[] args) {
        try {
            System.out.println(1);
            System.out.println(2);
            System.out.println(3);
            System.out.println(4/0);
            System.out.println(5); // 실행되지 않고 catch로 넘어감
            throw new Exception("고의로 발생시킨 예외"); // 고의로 개발자가 예외 던지기 가능.getMessage로 조회된다.
        } catch(ArithmeticException e) {
            e.printStackTrace(); // 예외 상황 메세지를 화면에 출력한다.
            System.out.println("예외 메세지 : " + e.getMessage());
        } catch (Exception e) {
            // Exeption은 모든 Exception의 조상이므로 어떤 예외든 Exeption을 거치게 된다.
            // 그러나 더 구체적인 예외가 있을 경우 해당 예외를 제외하고 모두 Exception을 거친다.
            System.out.println("Exeption");
        }
    }
}
