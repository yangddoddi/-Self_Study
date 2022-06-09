package basicClassAndMethod.MathClass;

import static java.lang.Math.*;

public class MathClass {
    public static void main(String[] args) {
        System.out.println("Math.PI = " + Math.PI);
        System.out.println("Math.E = " + Math.E);

        double num = 12.987156;
        num = Math.round(num*100);
        num = num / 100.0;
        System.out.println("Math.round(num*100)/100 = " + num);
        // 나눌 때 정수형으로 나누게 된다면 정수가 되어 소수가 사라져버린다.
        System.out.println(" 기준값 = " + num);
        System.out.println("Math.ceil(num) = " + Math.ceil(num)); // 올림
        System.out.println("Math.floor(num+0.99) = " + Math.floor(num)); // 내림
        System.out.println("Math.rint(num+0.99) = " + Math.rint(num)); // 반올림
        System.out.println("Math.round(num+0.99) = " + Math.round(num)); // 반올리거나 버림(반환값 int)

        // 예외를 발생시키는 메서드
        int x = 30000;
        int y = 20000;
        long longNum = 100000000L;
        System.out.println("기준값 x = " + x + ", y = " + y);
        System.out.println("addExact(x,y) = " + addExact(x,y));
        System.out.println("subtractExact(x,y) = " + subtractExact(x,y));
        System.out.println("multiplyExact(x,y) = " + multiplyExact(x,y));
        System.out.println("incrementExact(x) = " + incrementExact(x));
        System.out.println("decrementExact(x) = " + decrementExact(x));
        System.out.println("negateExact(x) = " + negateExact(x));
        System.out.println("toIntExact(longNum) = " + toIntExact(longNum));

        // 제곱, 제곱근
        System.out.println("Math.pow(100.0, 2) = " + Math.pow(100.0, 2));
        System.out.println("Math.pow(100.0, 0.5) = " + Math.pow(100.0, 0.5));
        System.out.println("Math.sqrt = " + Math.sqrt(100));

        // 삼각함수
        int x1 = 10;
        int y1 = 10;
        int x2 = 20;
        int y2 = 20;
        double c = sqrt((Math.pow(x2-x1,2)) + (Math.pow(y2-y1,2)));
        System.out.println("좌표 (10, 10), (20, 20)간의 거리 = " + c);

        double a = c * sin(PI/4);
        double b = c * cos(PI/4);
        double d = toDegrees(atan2(a,b));
        System.out.printf("a의 길이는 %f이고 b의 길이는 %f이다. 그리고 끼인 각은 %f도이다.%n", a,b,c);
        // ~ 삼각함수

        // float과 double의 정확도
        System.out.println("24자리의 2진수는 10진수로 몇 자리인가? log10(2) * 24 ? " + (log10(2) * 24));
        System.out.println("53자리의 2진수는 10진수로 몇 자리인가? log10(2) * 53 ? " + (log10(2) * 53));

        // 기타 메서드
        System.out.println("Math.max(x1, x2) = " + Math.max(x1, x2));
        System.out.println("Math.min(x1, x2) = " + Math.min(x1, x2));
        System.out.println("Math.abs(-10000) = " + Math.abs(-10000));
        System.out.println("Math.random() = " + Math.random()); // 0~1.0 double
    }
}
