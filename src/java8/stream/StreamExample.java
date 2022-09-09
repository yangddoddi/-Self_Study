package java8.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<SampleClass> sampleDataList = new ArrayList<>();
        sampleDataList.add(new SampleClass(1, "spring boot", true));
        sampleDataList.add(new SampleClass(2, "spring data jpa", true));
        sampleDataList.add(new SampleClass(3, "spring mvc", true));
        sampleDataList.add(new SampleClass(4, "spring core", true));
        sampleDataList.add(new SampleClass(5, "rest api development", true));

        List<SampleClass> sampleDataList2 = new ArrayList<>();
        sampleDataList2.add(new SampleClass(1, "spring boot", true));
        sampleDataList2.add(new SampleClass(2, "spring data jyp", true));
        sampleDataList2.add(new SampleClass(3, "spring mblack", true));
        sampleDataList2.add(new SampleClass(4, "spring pig", true));
        sampleDataList2.add(new SampleClass(5, "rest cat development", true));

        System.out.println("spring으로 시작하는 수업");
        sampleDataList.stream()
                .filter(s -> s.getTitle().startsWith("spring"))
                .forEach(System.out::println);

        System.out.println("close되지 않은 수업");
        sampleDataList.stream()
                .filter(e -> !e.isClosed())
                .forEach(System.out::println);

        System.out.println("수업 이름만 모아서 스트림 생성");
        sampleDataList.stream()
                .map(e -> e.getTitle())
                        .forEach(s -> System.out.println(s));

        List<List<SampleClass>> doubleClass = new ArrayList<>();
        doubleClass.add(sampleDataList);
        doubleClass.add(sampleDataList2);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        doubleClass.stream().flatMap(list -> list.stream())
                        .forEach(sd -> System.out.println(sd.getId()));


        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개까지만");
        Stream.iterate(10, i -> i+1)
                        .skip(10)
                                .limit(10)
                                        .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean bool = sampleDataList.stream()
                .anyMatch(e -> e.getTitle().contains("Test"));

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
        List<SampleClass> spring = sampleDataList.stream()
                .filter(e -> e.getTitle().contains("spring"))
                .collect(Collectors.toList());
    }
}
