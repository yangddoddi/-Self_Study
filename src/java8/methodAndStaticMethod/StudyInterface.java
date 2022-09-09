package java8.methodAndStaticMethod;

public interface StudyInterface {
    void printName();

    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    String getName();

    static void printAnything() {
        System.out.println("ㄹㅇ 아무거나");
    };
}
