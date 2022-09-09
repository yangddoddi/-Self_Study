package java8.functional_interface_lambda;

/*
* java. lang.function 패키지
*
* 입력, 반환값이 제네릭 T 값으로 설정되어 자유분방하게 사용 가능
*
* Function<T, R> 입력 값 한 개, 출력값 한 개를 받는다.
* BiFunction<T, U, R> 입력 값을 두 개 받는다.
* Consumer<T> void 메서드가 정의되어 반환값이 없다
* BiConsumer<T,T> 입력 값을 두 개 받아서 반환 값 Boolean으로 받는다
* Supplier<T> 특정 값을 반환하기만 한다. (입력값이 없음)
* Predicate<T> Boolean을 반환한다.
* UnaryOperator<T, T> 같은 타입의 입출력 타입을 가진다
* BinaryOperator<T, T, T> 같은 타입의 입력 두개와 출력값 한 개를 가진다.
*
* */

import java.util.function.*;

public class BasicFunctionalInterface {
    public static void main(String[] args) {
        Function<Integer, Integer> plus10 = n -> n+10;
        Function<Integer, Integer> multiply2 = n -> n*2;

        Function<Integer,Integer> plus10ComposeMultiply2 = n -> plus10.compose(multiply2).apply(n);
        Function<Integer,Integer> plus10AndThenMultiply2 = n -> plus10.andThen(multiply2).apply(n);

        Consumer<Integer> printPlus10 = (n) -> System.out.println(10+n);
        Supplier<Integer> get10 = () -> 10;
        Predicate<String> checkSecurity = (n) -> n.startsWith("security");

        UnaryOperator<Integer> unaryOperator = (n) -> n+100;


        System.out.println("plus10.apply(10) = " + plus10.apply(10));
        System.out.println("multiply10.apply(10) = " + multiply2.apply(10));
        printPlus10.accept(10);
        System.out.println("Supplier = " + get10.get());
        System.out.println("Predicate = " + checkSecurity.test("fakeSecurity"));
        System.out.println("Predicate = " + checkSecurity.test("securityTrue"));
        System.out.println("unaryOperator.apply(100) = " + unaryOperator.apply(100));


        /*
        *
        * compose ? 함수 (n) { compose(함수).apply(n) }
        *
        * andThen ? 함수 (n) { andthen(함수).apply(n) }
        *
        * */

        System.out.println("plus10.andThen(multiply10).apply(10) = " + plus10AndThenMultiply2.apply(2));
        System.out.println("plus10.compose(multiply10).apply(10) = " + plus10ComposeMultiply2.apply(2));
    }
}
