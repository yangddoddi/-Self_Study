package standardOfJava.LambdaExpression;

import java.util.function.*;

// 함수의 결합
public class LambdaStudy3 {
    public static void main (String[] args) {
        Function<Integer, String> f1 = (num) -> Integer.toBinaryString(num);
        Function<String, Integer> f2 = (str) -> Integer.parseInt(str);
        System.out.println(f1.apply(10));
        System.out.println(f2.apply("16"));

        // f2의 반환값을 f2에 입력한 결과
        Function<String, String> ff = f2.andThen(f1);
        System.out.println(ff.apply("20"));
        // f1의 반환값을 f2에 입력한 결과
        Function<Integer, Integer> ff2 = f2.compose(f1);
        System.out.println(ff2.apply(20));

        Function<String,String> f3 = str -> str;
        Function<String,String> f4 = Function.identity();
        // f3과 f4는 같은 의미이다. f(x) = x같이 x에 수를 대입하면 그것이 결과값인 함수를 뜻한다.

        Predicate<Integer> p1 = (num) -> { return num % 2 == 0; };
        Predicate<Integer> p2 = (num) -> { return num > 10; };

        // p1과 p2를 모두 만족하는지 ?
        Predicate<Integer> p3 = p1.and(p2);
        System.out.println(p3.test(12));
        // p1과 p2중 하나를 만족하는지 ?
        Predicate<Integer> p4 = p1.or(p2);
        System.out.println(p4.test(8));
        // p1을 부정한다 !p1이라고 생각하면 될 듯..
        Predicate<Integer> notP1 = p1.negate();
        // 세가지 결합 ( !(num%2==0) && num>10 )
        Predicate<Integer> all = notP1.and(p2);
        System.out.println(all.test(13));


        // 메서드 참조
        Function<String, Integer> mf1 = (str) -> Integer.parseInt(str);
        Function<String, Integer> mf2 = Integer::parseInt;
        // 위 둘은 완전히 동일하다. 아래도 모두 비슷한 예제들
        BiFunction<String, String, Boolean> mf3 = (str1,str2) -> str1.equals(str2);
        BiFunction<String, String, Boolean> mf4 = String::equals;
        // 생성자의 메서드 참조도 가능하다.
        BiFunction<String, Integer,MyClass> c1 = (str, num) -> new MyClass(str,num);
        BiFunction<String, Integer,MyClass> c2 = MyClass::new;
        // 배열 생성의 경우..
        Function<Integer, int[]> numArr1 = (num) -> new int[num];
        Function<Integer, int[]> numArr2 = int[]::new;
    }
}

class MyClass {
    String name;
    int num;
    MyClass(String name, int num) {
        this.name = name;
        this.num = num;
    }
}