package java8.methodAndStaticMethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class Java8BasicMethod {

    /*
    *
    * 리턴값이 없는 경우 forEach를 활용해 간단하게 반복문 사용 가능하다.
    * spliterator로 병렬처리 시 기존 요소를 분할할 수 있다. (순서는 보장하지 않음)
    * stream은 spliterator가 적용됨
    *
    * 이제 추상클래스 없이(상속 없이) 인터페이스 default method를 재구현해서 사용하면 됨
    *
    * */


    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("aaa");
        name.add("bbb");
        name.add("ccc");
        name.add("ddd");
        name.add("eee");

        name.forEach(System.out::println);
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> stringSpliterator = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("=============================");
        while(stringSpliterator.tryAdvance(System.out::println));

        long c = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("c"))
                .count();
        System.out.println(c);

        name.removeIf(s -> s.startsWith("a"));
        System.out.println(name);

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(String::compareToIgnoreCase);
        name.sort(compareToIgnoreCase.reversed().thenComparing(String::length));
    }
}
