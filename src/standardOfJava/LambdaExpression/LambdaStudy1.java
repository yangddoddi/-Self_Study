package standardOfJava.LambdaExpression;

// 메서드를 식으로 표현 가능, 메서드 선언에서 반환 타입과 메서드 이름이 빠진 형태.
// 람다식은 익명 객체와 동등하다
@FunctionalInterface
interface MyInterface {
    int sum(int x, int y);
}

//어노테이션 @FunctionalInterface는 해당 인터페이가 1개의 함수만을 갖도록 제한한다.
@FunctionalInterface
interface MyInterface2 {
    void run();
}

public class LambdaStudy1 {
    public static void main(String[] args) {
        int a = 7;
        int b = 5;
        MyInterface my = (x,y) -> x+y;
        System.out.println(my.sum(a,b));

        MyInterface2 m1 = () -> System.out.println("m1.run()");
        MyInterface2 m2 = new MyInterface2() {
            @Override
            public void run() {
                System.out.println("m2.run()");
            }
        };
        MyInterface2 m3 = getMyFunction(); // 반환값을 받음

        m1.run();
        m2.run();
        m3.run();

        excute(m1); // 매개변수로..
        excute(()->System.out.println("run()")); // MyInterface2 m1 = () -> System.out.println("m1.run()");를 생략한 것과 같다.


//        System.out.println(()->{}); // 람다식은 익명 객체이기 때문에 타입이 없다. 따라서 바로 사용 불가.
        System.out.println((MyInterface2)()->{}); // Object로 형번환이 생략된 것이다.
//        System.out.println((MyInterface2)(()->{}).toString());
        System.out.println(((Object)(MyInterface2)(()->{})).toString()); // Object로 형변환 후 toString메서드 사용
        // standardOfJava.LambdaExpression.LambdaStudy1$$Lambda$5/1989780873@58372a00
        // standardOfJava.LambdaExpression.LambdaStudy1$$Lambda$6/81628611@6d03e736
        // 일반 익명 객체와 달리 "외부클래스이름&&Lambda/해쉬코드"로 작성되어 있다.

        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.method(100);
    }

    //매개변수가 MyInterface2인 경우
    static void excute(MyInterface2 m) {
        m.run();
    }

    //반환값이 MyInterfac2인 경우
    static MyInterface2 getMyFunction() {
        MyInterface2 m = () -> System.out.println("f3.run()");
        return m;
    }
}

class OuterClass {
    int val = 10;

    class InnerClass {
        int val = 20;

        void method(int i) {
            int val = 30; // i와 val은 람다식 내에서 참조하고 있으므로 상수로 취급된다.

            MyInterface2 m = () -> {
                System.out.println("i           : " + i); // 상수
                System.out.println("val            : " + val); // 상수 (20)
                System.out.println("this.val       : " + this.val); // 20
                System.out.println("Outer.this.val : " + OuterClass.this.val); // 10
            };

            m.run();
        }
    }
}


class basicExample {
//    int max(int a, int b) {
//        return  a > b  ? a : b;
//    }

    // 람다식 변환 =>
    // (int a, int b) -> { return a > b ? a : b }
    // (a, b) -> a > b ? a : b  대부분 타입 추론이 가능하여 타입 생략 가능
    // a -> a * a 매개변수가 하나인 경우 괄호까지 생략 가능하다.
    // 괄호가 없을 때는 세미콜론도 붙이지 않는다.

    // 문제 1
//    void printVar (standardOfJava.String name, int i) {
//        System.out.println(name+"="+i);
//    } 변환하기

//   답 (standardOfJava.String name, int i) -> System.out.println(name+"="+i);

    // 문제 2
//    int square(int x) { return x * x; }

//   답 x -> x * x

    // 문제 3
//    int roll() { return (int)(Math.random() * 6); }

//    답
//    () -> (int)(Math.random()*6)

    // 문제 4
//    int sumArr(int[] arr) {
//        int sum = 0;
//        for (int i:arr) {
//            sum += i;
//        }
//        return sum;
//    }
//
    // 답
//    (int[] arr) -> {
//        int sum =0;
//        for (int i:arr){
//            sum += i;
//        }
//        return sum;
//    }
}