package java8.functional_interface_lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/*
*
* Lambda Method Reference
* 스태틱 메서드 사용 시 타입::인스턴스 메서드로 즉시 사용 가능
* 생성자 타입::new로 기본 생성자 즉시 생성 가능
* 반환값을 가진 함수형 인터페이스를 사용하면 생성자도 지정 가능
*
* */

public class LambdaMethodReference {
    public static void main(String[] args) {
        Function<Integer, String> intToString = (i) -> "number";

        UnaryOperator<String> hi = Greeting::hi;
        hi.apply("hihi");

        Supplier<Greeting> getGreetingSupplier = Greeting::new;
        Greeting greeting = getGreetingSupplier.get();

        Function<String, Greeting> gree = Greeting::new;
        Greeting newGreeting = gree.apply("하염");

        String[] colors = {"white", "black", "green"};
        Arrays.sort(colors, String::compareToIgnoreCase);
    }
}

class  Greeting {
    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String hi(String name) {
        return "hi " + name;
    }
}
