package java8.stream;

/*
*
* Stream API
* 데이터를 담고 있는 역할이 아니다.
* 원본 데이터에 아무런 영향을 주지 않는다.
* 스트림으로 처리하는 데이터는 오직 한 번만 처리한다.
* 중계 메서드는 lazy하다. (중계 : stream 종료 : 특정 타입)
*
* 손쉽게 병렬처리할 수 있다.
* 단 컨텍스트 비용 때문에 병렬처리가 오히려 더 느릴 수 있음.
*
* 스트림 파이프라인?
* 0개 혹은 다수의 중개 오퍼레이터(Intermediate operation)와 한 개의 종료 오퍼레이션(terminal operation)
*
* 중개 오퍼레이터?
* Stream을 리턴한다.
* 대다수는 statless하다
*
*
* */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("aaa");
        names.add("bbb");
        names.add("ccc");
        names.add("ddd");
        names.add("eee");

        Stream<String> nameStream = names.stream().map(String::toUpperCase);

        List<Object> collect = names.stream().map(e -> {
                    System.out.println(e);
                    return e.toUpperCase();
                }) // 이 단계까지는 아무것도 실행되지 않는다.
                .collect(Collectors.toList());

        for(String name : names) {
            System.out.println(name);
            name.toUpperCase();
        } // 병렬 처리가 어렵다


        List<String> collect2 = names.parallelStream().map((s) ->
        {
            System.out.println(s + " " + Thread.currentThread().getName());
            // ForkJoinPool을 사용해서 병렬처리함
            return s.toUpperCase();
        })
                .collect(Collectors.toList());
    }
}
