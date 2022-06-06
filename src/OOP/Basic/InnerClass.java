package OOP.Basic;

class OuterClass {
    private final int privateInt = 0;
    int num = 2;

    class InstanceInner {
        int i = privateInt;
        int num = 3;
        // 외부 클래스의 프라이빗 멤버 변수 접근 가능
        void InnerInnerMethod() {
            int num = 4;
            System.out.println("Outer.this.num : " + OuterClass.this.num);
            System.out.println("this.num : " + this.num);
            System.out.println("num : " + num);
            // 결과 2, 3, 6
        }
    }
    static class StaticInner {}

    InstanceInner inner = new InstanceInner(); // inner 클래스끼리 직접 접근 가능
    static StaticInner staticInner = new StaticInner(); // static 클래스끼리 직접 접근 가능

    static void staticMethod() {
//        InstanceInner obj = new InstanceInner();
//        static method는 instance member에 접근할 수없다.
        StaticInner obj2 = new StaticInner();
        class LocalInner{};
        LocalInner local = new LocalInner();
        // 지역 클래스는 해당 스코프 내에서만 생성 가능
    }

    void instanceMethod() {
        InstanceInner obj3 = new InstanceInner();
        StaticInner obj4 = new StaticInner();
        int y = 0;
//        LocalInner local = new LocalInner();
//        메서드 내부에서 지역적으로 선언된 클래스는 외부에서 생성 불가능
        class LocalInner {
            int i = privateInt;
            int x = num;
            int z = y; // JDK 1.5까지는 final 안 붙으면 에러 뱉어냄.
        }
    }
}

public class InnerClass {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InstanceInner inner = outer.new InstanceInner();
        // 내부 클래스를 외부 클래스가 아닌 다른 클래스에서 인스턴스 생성하는 경우
        // 아우터 클래스를 먼저 인스턴스화한 후 인스턴스 생성해야함.
        OuterClass.StaticInner staticInner = new OuterClass.StaticInner();
        // 스태틱 클래스는 바로 생성 가능ㅎ다.
        inner.InnerInnerMethod();
    }
}
