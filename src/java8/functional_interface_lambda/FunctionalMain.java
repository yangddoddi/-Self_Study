package java8.functional_interface_lambda;

/*
*
* 람다 표현식
* -> 함수형 인터페이스의 인스턴스를 만드는 것.
*
* 자바의 함수형 프로그래밍
* -> 함수를 1급 객체로 사용할 수 있다. (매개변수, 반환값, 할당, 비교연산이 가능하다는 의미.)
* -> 순수 함수 : 사이드 이펙트를 만들 수 없다, 상태가 없다.
*  즉, 같은 인자를 받으면 항상 같은 결과 반환해야하고 인자의 값은 변하지 않아야 한다.
* -> 고차 함수 : 함수가 함수를 매개 변수로 받거나 리턴할 수 있다.
성 -> 불변성
*
* */


public class FunctionalMain {

    public static void main(String[] args) {
        // 익명 내부 클래스 anonymous inner class
        RunSomething runSomething1 = new RunSomething() {
            @Override
            public int doIt(int num) {
                return num+10;
            }
        };

        // 람다 표현식1
        RunSomething runSomething2 = number -> number+10;

        // 람다 표현식2
        RunSomething runSomething3 = number -> {
            return number+20;
        };

        runSomething1.doIt(10);
        runSomething2.doIt(10);
        runSomething3.doIt(10);
    }
}
