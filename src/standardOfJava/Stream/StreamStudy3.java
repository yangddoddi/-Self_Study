package standardOfJava.Stream;

import java.io.*;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStudy3 {
    public static void main(String[] args) {
        // map - 저장된 값 중 원하는 값만 뽑아내거나 특정 형태로 변환할 때 사용한다. 여러번 사용 가능하다.
        Stream<File> fileStream = Stream.of(
                new File("stream_study1.txt"),
                new File("stream_study2.txt"),
                new File("stream_study3.java")
                );

        fileStream.map(File::getName).forEach(System.out::println);
//        stream_study1.txt
//        stream_study2.txt
//        stream_study3.java

        Stream<File> fileStream2 = Stream.of(
                new File("stream_study1.txt"),
                new File("stream_study2.txt"),
                new File("stream_study3.java")
        );

        fileStream2.map(File::getName)
                .filter(s -> s.indexOf('.') != -1) // 확장자가 있는 것만
                .map(s -> s.substring(s.indexOf('.')+1)) // 확장자만 남기고 잘라내기
                .map(String::toUpperCase) // 대문자로 전환
                .distinct() // 중복 제거
                .forEach(System.out::println);

        // peek() 연산 사이 결과를 stream을 소모하지 않고 확인 가능하다
        Stream<File> fileStream3 = Stream.of(
                new File("stream_study1.txt"),
                new File("stream_study2.txt"),
                new File("stream_study3.java")
        );

        fileStream3.map(File::getName)
                .filter(s -> s.indexOf('.') != -1) // 확장자가 있는 것만
                .peek(System.out::println)
                .map(s -> s.substring(s.indexOf('.')+1)) // 확장자만 남기고 잘라내기
                .peek(System.out::println)
                .map(String::toUpperCase) // 대문자로 전환
                .distinct() // 중복 제거
                .forEach(System.out::println);

        // mapToint(), mapToLong(), mapToDouble()
        // 반환값이 기본형일 경우 위의 메서드가 더 효율적이고 sum, average, max, min이라는 편리한 메서드를 제공한다.
        // 다만 이런 메서드들은 최종연산 메서드이기 때문에 중복 사용할 수 없다.
        List<Student2> list = Arrays.asList(
                new Student2("양만식", 3, 95),
                new Student2("김바보", 1, 75),
                new Student2("장뚝딱", 2, 87),
                new Student2("이영재", 3, 45),
                new Student2("마동석", 2, 100),
                new Student2("오이남", 3, 72),
                new Student2("남이오", 1, 95)
        );

        IntStream studentStream = list.stream().mapToInt(Student2::getScore);
        IntStream studentStream2 = list.stream().mapToInt(Student2::getScore);
        IntStream studentStream3 = list.stream().mapToInt(Student2::getScore);
        IntStream studentStream4 = list.stream().mapToInt(Student2::getScore);
//        int allScore = studentStream.sum();
//        System.out.println(allScore); 편리하지만 반복 사용할 수 없다.
        // 그래서 summaryStatistics라는 굉장히 편리한 클래스가 제공되고 있다.
        IntSummaryStatistics stat = studentStream.summaryStatistics();
        System.out.println("stat.getSum() ? " + stat.getSum());
        System.out.println("stat.getAverage() ? " + stat.getAverage());
        System.out.println("stat.getMin() ? " + stat.getMin());
        System.out.println("stat.getMax() ? " + stat.getMax());
        System.out.println("stat.getCount() ? " + stat.getCount());

        // IntStream -> standardOfJava.Stream<T>
        Stream studentStream5 = studentStream2.mapToObj((i)->i+",");
        // IntStream -> standardOfJava.Stream<Integer>
        Stream<Integer> studentStream6 = studentStream3.boxed();
        // standardOfJava.Stream<Integer> -> IntStream ? Integer::intValue
        // standardOfJava.Stream<standardOfJava.String> -> IntStream ? Integer::parseInt
        IntStream studentStream7 = studentStream6.mapToInt(Integer::intValue);

        //flatMAp() - standardOfJava.Stream<T[]>를 standardOfJava.Stream<T>로 전환
        Stream<String[]> arrStream = Stream.of(
                new String[]{"당근", "호박", "고구마"},
                new String[]{"수박", "사과", "참외"},
                new String[]{"맛동산", "썬칩", "포도"}
        );

        Stream<String> strArrStream = arrStream.flatMap(Arrays::stream);

        // . 을 구분자로 잘라낼 것이다.
        String[] lineArr = {
                "자.바.좋.아",
                "자.바.싫.어"
        };
        Stream<String> arrStream2 = Arrays.stream(lineArr);
        Stream<String> strArrStream2 = arrStream2.flatMap(line->Stream.of(line.split("\\.")));
        strArrStream2.forEach(System.out::println);

        // flatMap을 이용해서 두개의 스트림을 합칠 수도 있다.
        Stream<String> strString1 = Stream.of("코카콜라","웰치스","스프라이트");
        Stream<String> strString2 = Stream.of("칠성사이다","펩시","미란다");
        Stream<Stream<String>> strStrStream = Stream.of(strString1,strString2);
        Stream<String> newStrString = strStrStream.map(arr -> arr.toArray(String[]::new)).flatMap(Arrays::stream);
        newStrString.forEach(System.out::println);
    }
}

class Student2 implements Comparable<Student> {
    int ban;
    int score;
    String name;

    Student2(String name, int ban, int score) {
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
        return (this.name).compareTo(s.name);
    }

    public String toString() {
        return this.name + ", " + this.ban + "반, " + this.score + "점";
    }
}
