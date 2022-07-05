package standardOfJava.Stream;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

// 스트림의 기본 생성과 활용법
public class StreamStudy1 {
    public static void main(String[] args) {
        String[] strArr = { "hhh", "bbb", "ccc"};
        List<String> strList = Arrays.asList(strArr);

        Stream<String> stringStream1 = strList.stream();
        Stream<String> stringStream2 = Arrays.stream(strArr);

        stringStream1.sorted().forEach(System.out::println);
        stringStream2.sorted().forEach(System.out::println);
        // 위 코드는 아래와 같다.
        Arrays.sort(strArr);
        for(String str:strArr) {
            System.out.println(str);
        }
        // stream은 일회용이며 실제로 값을 변경하지 않는다. (iterator와 비슷하다.)
        // 스트림은 작업을 내부 반복으로 처리한다. forEach는 메서드 내부로 for문을 넣은 것과 같다.

        // 스트림의 연산은 중간 연산과 최종 연산으로 나눌 수 있다
        // 중간연산 : 연산 결과가 스트림이 아닌 연산 , 연속적인 연산 가능
        // 최종연산 : 연산 결과가 스트림이 아닌 연산 , 단 한 번만 가능

        Stream<String> stringStream3 = strList.stream();
        stringStream3.distinct().limit(5).sorted().forEach(System.out::println);
        // 모든 중간 연산 결과는 stream이지만 그 과정이 모두 같은 stream은 아니다.

//        standardOfJava.String[] strArr2 = {"aa","aa","BB","ff","gg","cc","ASD"};
//        standardOfJava.Stream<standardOfJava.String> stringStream4 = Arrays.stream(strArr2);
////        standardOfJava.Stream<standardOfJava.String> fillteredStream = stringStream4.filter();
//        standardOfJava.Stream<standardOfJava.String> distinctedStream = stringStream4.distinct();
//        standardOfJava.Stream<standardOfJava.String> sortedStream = stringStream4.sorted();
        // .. 이런 식으로 계속해서 스트림이 새로 생성되고 있다


        // 문자열 스트림 생성 예시
        Stream<String> strStream1 = Stream.of("A","B","C","D");
        Stream<String> strStream2 = Stream.of(new String[]{"A","B","C","D"});
        Stream<String> strStream3 = Arrays.stream(new String[]{"A","B","C","D"});
        Stream<String> strStream4 = Arrays.stream(new String[]{"A","B","C","D"},0, 2);
        strStream4.forEach(System.out::println);

        // 기본형은 래퍼 클래스를 사용하면 비효율적이므로 Int,Double,Long Stream이 각각 준비되어 있다.
        IntStream intS1 = IntStream.of(1,2,3,4,5,6);
        IntStream intS2 = IntStream.range(7,12); // 7 ~ 11 ( 7 <= x < 12 )
        IntStream intS3 = IntStream.rangeClosed(13,20); // 13 ~ 20 ( 13 <= x <= 20 )
        int[] intArr = intS2.toArray();
        System.out.println(Arrays.toString(intArr));

        // 난수 생성
        // ints에서 사이즈와 최대값을 지정해주지 않을 경우
        IntStream randomNum1 = new Random().ints();
        int[] randomArr1 = randomNum1.limit(10).toArray();
        System.out.println(Arrays.toString(randomArr1));
        // longs에서 사이즈를 지정해주고 최소, 최대값을 지정해주지 않을 경우
        LongStream randomNum2 = new Random().longs(10);
        long[] randomArr2 = randomNum2.toArray();
        System.out.println(Arrays.toString(randomArr2));
        // 사이즈, 최소, 최대값을 모두 지정해주는 경우
        DoubleStream randomNum3 = new Random().doubles(10, -10, 10);
        double[] randomArr3 = randomNum3.toArray();
        System.out.println(Arrays.toString(randomArr3));

        // 람다식
        // iterate(), generate()
        // 둘은 비슷하나 iterate는 이전 결과를 이용해서 stream을 반복하고 generate는 이전 결과를 참고하지 않는다.
        // 또한 이들은 기본형 스트림 타입의 참조 변수로 다룰 수 없다.
        Stream<Integer> evenStream = Stream.iterate(0, n -> n +2);
        Stream<Double> randomStream = Stream.generate(Math::random);
//        evenStream.forEach(System.out::println);

        // File
//        standardOfJava.Stream<standardOfJava.String> fileStream = Files.lines("PATH.txt");

        // 빈 스트림
        // 스트림 연산 결과가 null인 것보다 빈 스트림을 반환하는 것이 낫다.
        Stream<String> emptyStream = Stream.empty();

        // 두 스트림의 연결
//        int[] a = {1,2,3,4,5,6};
//        int[] b = {7,8,9,10,11,12};
        List<Integer> a = Arrays.asList(1,2,3,4,5,6);
        List<Integer> b = Arrays.asList(7,8,9,10,11,12);
        Stream<Integer> is1 = a.stream();
        Stream<Integer> is2 = b.stream();
        Stream<Integer> is3 = Stream.concat(is1,is2);
        is3.forEach(System.out::println);

        // 스트림 잘라내기 - skip(), limit()
        // skip(i)는 i번째까지 건너뛰고, limit(i)는 요소를 i개까지 제한한다.
        int[] numberArr = {1,2,3,4,5,6,7,8};
        IntStream intStream = Arrays.stream(numberArr);
        int[] newArr = intStream.skip(3).limit(3).toArray();
        System.out.println(Arrays.toString(newArr));

        // 스트림 요소 걸러내기 - filter() distinct()
        String[] strArrr = {"바나나","바나나","딸기","포도"};
        Stream<String> arrrStream1 = Arrays.stream(strArrr);
        Stream<String> arrrStream2 = Arrays.stream(strArrr);
        Object[] newArrr1 = arrrStream1.distinct().toArray();
        System.out.println(Arrays.toString(newArrr1));
        // Predicate를 추가하거나 람다식으로 filter 가능
        arrrStream2.filter((String str) -> { return str.length() < 3;}).forEach(System.out::println);

        // 정렬 - sorted()
        // Comparator의 기본 메서드와 static 메서드를 활용하면 다양한 기본 정렬 옵션을 이용할 수 있다.
        String[] aa = { "순대국밥", "돼지", "어레이", "콜라", "메뉴판"};
        int[] bb = { 1, 41, 32, 12, 11111, 123, 22};
        Stream<String> aaStream = Arrays.stream(aa);
        IntStream bbStream = Arrays.stream(bb);
        Object[] aaa = aaStream.sorted(Comparator.comparing(String::length)).toArray();
        int[] bbb = bbStream.sorted().toArray();
        System.out.println(Arrays.toString(aaa));
        System.out.println(Arrays.toString(bbb));

    }
}
