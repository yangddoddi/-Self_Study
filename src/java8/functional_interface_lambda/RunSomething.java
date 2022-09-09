package java8.functional_interface_lambda;

/*
*
* 메서드를 하나만 가진 인터페이스 == 함수형 인터페이스
* 단, static method, default method는 가능하다.
* FunctionalInterface => 메서드 개수 제한해주는 것 외에 별 다른 기능은 없으나 명시해주는 역할.
*
* */

@FunctionalInterface
public interface RunSomething {

    int doIt(int num);

    static void printName() {
        System.out.println("aa");
    }

    default void printAge() {
        System.out.println(100);
    }
}
