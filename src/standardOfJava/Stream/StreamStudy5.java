package standardOfJava.Stream;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

// 최종연산은 스트림의 요소를 소모하기 때문에 단 한 번만 가능하다.
public class StreamStudy5 {
    public static void main(String[] args) {
        String[] strArr = {"돼지국밥", "순대국밥", "섞어국밥"};
        int[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11};
        // 1. void forEach(Consumer<? super T> action)
        // 주로 스트림의 요소를 출력할 때 사용한다.
        IntStream s2 = IntStream.of(intArr);
        s2.forEach(System.out::println); // 1,2,3,4,5..

        // 2. allMatch(), anyMatch(), noneMatch(), findFirst(), findAny()
        // 스트림의 요소에 대해 지정된 조건에 요소의 일치 여부를 판단. Predicate를 요구하며 boolean을 반홚나다.
        IntStream s3 = IntStream.of(intArr);
        System.out.println(s3.allMatch((num) -> num < 11)); // true
        IntStream s4 = IntStream.of(intArr);
        System.out.println(s4.filter((num) -> num > 8).findFirst()); // OptionalInt[10]

        // 3. count(), sum(), average(), max(), min()
        // 기본형이 아닐 경우 max, min, count만 재공된다.
        IntStream s5 = IntStream.of(intArr);
        System.out.println(s5.max());
        Stream<Integer> s6 = IntStream.of(intArr).boxed();
//        System.out.println(s6.max(Comparator.comparing(Integer::max)));
//

        // 4. reduce()
        // 스트림의 요소를 줄여나가며 연산을 실행하고 결과를 반환한다.
        // sum(), max(), min(), count()도 모두 reduce로 작성된 것이다.
        IntStream intStream = IntStream.of(0);
        int count = intStream.reduce(0, (a, b) -> a + 1); // 초기값 0, 매개변수 a,b가 있을 때 a에 1을 계속해서 더한다.
//        int sum = intStream.reduce(0, (a,b) -> a+b); // 초기값 0, a += b;
//        int max = intStream.reduce(Integer.MIN_VALUE, (a,b) -> a>b ? a:b); // a와 b 중 a 가 크면 a를 반환, 작으면 b를 반환하는 연산을 반복
//        int min = intStream.reduce(Integer.MAX_VALUE, (a,b) -> a<b ? a:b); // 위와 같다.
        // 메서드 참조로 바꾸면 아래와 같다 (초기값이 없으므로 Optional<T>를 반환한다)
//        OptionalInt optionalInt = intStream.reduce(Integer::max);
//        int max2 = optionalInt.getAsInt();

        // 5. collect()
        // collect()가 스트림의 요소를 수집하기 위한 방법을 정의한 것이 collector이다.
        // collector는 Collector의 인터페이스를 구현한 것이고, 이는 미리 작성된 다양한 static 메서드를 가지고 있따
        // Obejct collect(Collector collector) // Collector를 구현한 클래스의 객체를 매개변수로
        Student3[] studentArr = {
                new Student3("기영", 3, 95),
                new Student3("기철", 2, 85)
        };
        Stream<Student3> student3Stream = Stream.of(
                new Student3("기영", 3, 95),
                new Student3("기철", 2, 85)
        );
        Stream<Student3> student3Stream2 = Stream.of(
                new Student3("기영", 3, 95),
                new Student3("기철", 2, 85)
        );
//        Student3[] stuNames2 = student3Stream2.toArray(Student3[]::new);


        // 5-1. 스트림을 컬렉션/배열로 변환 : toList(), toSet(), toMap(), toCollection(), toArray()
        List<String> arrayList = student3Stream.map(Student3::getName).collect(Collectors.toList());
        Map<String, Student3> map2 = Stream.of(studentArr).collect(Collectors.toMap((s) -> s.getName(), p -> p)); // key를 각 학생들의 이름으로 지정하고 value는 기존 값을 그대로 넣었다.
        ArrayList<Integer> arrayList2 = Stream.of(studentArr).map(Student3::getScore).collect(Collectors.toCollection(ArrayList::new));
//
//        Object[] stuNames = student3Stream2.toArray();
//
//        System.out.println(Arrays.toString(stuNames));
//
//        // 5-2. 통계 - counting(), summingInt(), averageingInt(), maxBy(), minBy()
////        long count2 = student3Stream2.count(); 아래와 같다
//        long count3 = student3Stream2.collect(counting());
////        long totalScore1 = student3Stream2.mapToInt(Student3::getScore).sum(); 아래와 같다
//        long totalScore2 = student3Stream2.collect(summingInt(Student3::getScore));
////        OptionalInt topScore = student3Stream2.mapToInt(Student3::getScore).max(); 아래와 같다
//        Optional<Student3> topScore = student3Stream2.collect(maxBy(Comparator.comparing(Student3::getScore)));
////        OptionalInt
//
//        // 5-3 리듀싱 - reducing
//        // Collector reducing(BinaryOperator<T> op)
//        // Collector reducing(T identify, BinaryOperator<T> op)
//        // Collector reducing(U identify, Function<T,U> mapper, BinaryOperator<U> op)
//        IntStream intStream2 = new Random().ints(1,46).distinct().limit(6);
////        OptionalInt max = intStream.max();
//        Optional<Integer> max = intStream2.boxed().collect(reducing(Integer::max));
//        long sum = intStream2.boxed().collect(reducing(0,(a,b) -> a+b)); // 초기값을 0을 줬기 때문에 long에 대입할 수 있는 것이다.
//        int grandTotal = student3Stream2.collect(reducing(0,Student3::getScore,Integer::sum));

        // 5-4 joining
        String allStudentNames = student3Stream2.map(Student3::getName).collect(joining(","));
        System.out.println(allStudentNames);


        Student3[] list2 = {
                new Student3("양만식", 3, 95),
                new Student3("김바보", 1, 75),
                new Student3("장뚝딱", 2, 87),
                new Student3("이영재", 3, 45),
                new Student3("마동석", 2, 100),
                new Student3("오이남", 3, 72),
                new Student3("남이오", 1, 95)
        };
        // collect를 이용하면 종합 선물 세트처럼 한 번에 결과물을 얻을 수 있다.
        IntSummaryStatistics stat2 = Stream.of(list2).collect(summarizingInt(Student3::getScore));
        System.out.println(stat2);


    }
}


class Student3 implements Comparable<Student> {
    int ban;
    int score;
    String name;

    Student3(String name, int ban, int score) {
        this.name = name;
        this.ban = ban;
        this.score = score;
    }

    public int getBan() {
        return this.ban;
    }
    public int getScore() {
        return this.score;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Student s) {
        return (this.score) - (s.score);
    }

    public String toString() {
        return this.name + ", " + this.ban + "반, " + this.score + "점";
    }
}
