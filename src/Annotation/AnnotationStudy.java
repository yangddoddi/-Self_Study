package Annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnnotationStudy {
    @SuppressWarnings({"unchecked", "varargs", "rawtypes", "deprecation"})
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(1);
        //SuppresWarnings는 지정할 수 있는 각 문제에 대한 경고를 제거해준다.

        Test test1 = new Test();
        System.out.println(test1.newMethod());
        System.out.println(test1.oldMethod());
        //deprecation에 대한 경고를 SuppressWarnings으로 제거했다.
    }


}

class Test {
    void test(){}

    @Deprecated
    String oldMethod(){
        return "old method";
    }
    // Deprecated는 이를 대체할 다른 대상이 생겼으니 사용하지 안흥ㄹ 것을 권고하는데 사용된다.(강제성은 없다.)
    String newMethod(){
        return "new method";
    }
}

class Test2 extends Test {
    @Override
    void test(){}
    // Override
    // 만약 Override라고 애너테이션을 붙여주지 않는다면 오타로 testt라고 써도 새로운 메서드로 인식한다
    // 애너테이션을 사용함으로 실수를 미연에 방지해준다.
}

@FunctionalInterface
interface Able {
    public abstract void able();
}
//FunctionalInterface는 함수형 인터페이스를 올바르게 선언했는지 확인해준다.

class MyArrayList<T> {
    T[] arr;

    @SafeVarargs
    MyArrayList(T... arr) {
        this.arr = arr;
    }

    @SafeVarargs
//    @SuppressWarnings("varargs")
    public static <T> MyArrayList<T> asList(T... a) {
        // 왜 문제가 되는가?
        // 컴파일시 메서드에 선언된 T가 Object로 바뀌는데 매개변수까지 바뀌므로 위험하다고 경고함
        // 그러나 컴파일러가 타입 T에 해당하지 않는 것은 애초에 컴파일을 하지 못하게 만들 것이므로 안전하다
        // 따라서 해당 경고를 제거함
        return new MyArrayList<T>(a);
    }

    public String toString() {
        return Arrays.toString(arr);
    }
}