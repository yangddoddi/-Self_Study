package java8.functional_interface_lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

/*
*
* Lambda
*
* 바디가 한 줄이면 중괄호와 return은 생략 가능하다.
* 파라미터 타입은 인스턴스 선언 시점에 정의되기 때문에 생략 가능하다.
* 람다는 익명 클래스를 생성하는 것과 마찬가지이기 때문에 외부 변수 참조 시 해당 변수는 불변이여야 한다.
* 단 외부 변수가 사실상 final인 경우 final을 별도로 선언하지 않아도 된다.
*
* 로컬 클래스, 익명 클래스와 람다의 차이
* 로컬 클래스와 익명 클래스는 하나의 스코프를 가지나, 람다는 외부와 같은 스코프를 가진다.
* 따라서 내부에 외부(?) 존재하는 변수와 같은 변수명을 가진 변수를 생성할 수 없다.
*
* */

public class LambdaPlus {
    public static void main(String[] args) {
        Supplier<Integer> get10 = () -> 10;
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;


    }

    private void run() {
        int baseNumber = 10;

        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 20;
                System.out.println(baseNumber);
            }
        }

        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                int baseNumber = 30;
                System.out.println(baseNumber);
            }
        };

        IntConsumer printInt = (i) -> {
//            int baseNumber = 30; 불가능
            System.out.println(baseNumber);
        };

//        baseNumber++; 람다는 불가능
    }
}

