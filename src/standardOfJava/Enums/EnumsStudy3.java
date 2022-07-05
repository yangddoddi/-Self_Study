package standardOfJava.Enums;

// 열거형의 진실(?)
// 열거형의 상수는 모두 하나의 객체이다.
// enum Animal { RABBIT, LION }
// 위 열거형은 아래와 같이 표현할 수 있다.
// class Animal {
//    Animal RABBIT = new Animal("RABBIT");
//    Animal LION = new Animal("RABBIT");
//
//    private standardOfJava.String name;
//}

public class EnumsStudy3 {
    public static void main(String[] args) {
        MyTransportation m1 = MyTransportation.BUS;

        System.out.println(m1.name());
        System.out.println(m1.fare(10));
    }
}

// Enum을 클래스로 구현해보기

abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
    // T가 MyEnum을 상속받은 클래스라는 것이 명시되어 있기 때문에 comapreTo에서 t.ordinal로 바로 작성이 가능하다.
    int ordinal = 0;
    String str;

    MyEnum(String str) {
        this.str = str;
        ordinal++;
        // 상수가 추가될 때마다 ordinal이 1씩 증가한다.
    }

    public String toString() { return this.str; }
    public int compareTo(T t) {
        return this.ordinal - t.ordinal;
    }
}

abstract class MyTransportation extends MyEnum {
    static final MyTransportation BUS = new MyTransportation("BUS",100) { int fare(int distance) { return distance * BASIC_FARE; }};

    abstract int fare(int distance);
    protected final int BASIC_FARE;

    // 상수로 활용하기 위함이므로 MyTransportation.BUS로 호출할 것이기 때문에 애초에 인스턴스를 생성할 수 없도록 생성자를 private
    private MyTransportation(String name, int basicFare) {
        super(name);
        BASIC_FARE = basicFare;
    }

    public String name() { return this.str; }
    public String toString() { return this.str; }
}

// 추상 클래스 복습할 것..