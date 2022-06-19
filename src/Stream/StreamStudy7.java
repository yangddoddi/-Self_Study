package Stream;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.*;

public class StreamStudy7 {
    public static void main(String[] args) {
        String[] strArr = {"순대국밥","먹고싶다","냠냠냠냠"};

        Stream<String> stream = Stream.of(strArr);
        String result = stream.collect(new ConcatCollector());
        System.out.println(result);
        // 순대국밥먹고싶다냠냠냠냠
    }
}

class ConcatCollector implements Collector<String, StringBuilder, String> {

    @Override
    public Supplier<StringBuilder> supplier() {
        return () -> new StringBuilder(); // 작업 결과를 어디에 저장할 것인가?
    }

    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
        return (sb , s) -> sb.append(s); // 연산 과정을 어떻게 누적시킬 것인가?
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (sb1, sb2) -> sb1.append(sb2); // 병렬작업 시 어떻게 병합할 것인가?
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        return (StringBuilder sb) -> sb.toString(); // 결과를 어떻게 반환할 것인가?
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.CONCURRENT,
                Characteristics.UNORDERED)); // 병렬로 처리할 수 있고, 스트림 요소의 순서가 유지될 필요 ㅇ벗다.

    }
}