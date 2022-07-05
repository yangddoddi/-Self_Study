package standardOfJava.Stream;

import java.util.*;

public class StreamStudy4 {
    public static void main(String[] args) {
        String str = "123";
        Optional<String> optVal1 = Optional.of(str);
        Optional<String> optVal2 = Optional.of("def");
        Optional<String> optVal3 = Optional.of(new String("ghi"));
        // 만약 찹조 변수의 값이 null일 가능성이 있으면 ofNullabl을 사용해야 한다.
        // of()는 매개변수 값이 null이면 NullPointerException이 발생하기 때문이다.
        Optional<String> optVal4 = Optional.ofNullable(new String("jkl"));
        // 초기화시 널이 아닌 empty로 초기화하는 것이 바람직하다.
        Optional<String> optVal5 = null;
        Optional<String> optVal6 = Optional.empty();
        // Optional도 Stream과 마찬가지로 map과 filter를 사용할 수 있다.
        // Optional 객체의 참조변수 값이 null일 것을 대비해서 orElse로 값을 지정하거나 orElseGet으로 람다식을 지정할 수도 있고 orElseThrow로 예외를 발생시킬 수도 있다.
        int result = optVal1.filter(s->s.length()>2).map(Integer::parseInt).orElse(0);
        System.out.println(result);

        // 값이 null이면 false, 아니면 true를 반환한다.
        if (Optional.ofNullable(str).isPresent()) {
            System.out.println(str);
        }
        Optional.ofNullable(str).ifPresent(System.out::println); // 만약 변수가 null이면 실행, 아니면 가만히

        // stream과 마찬가지로 Optional도 OptionalInt, OptionalDouble, OptionalLong이 존재한다.
        OptionalInt oi1 = OptionalInt.of(0);
        OptionalInt oi2 = OptionalInt.empty();

        System.out.println(oi1.isPresent()); // true
        System.out.println(oi2.isPresent()); // false
        System.out.println(oi1.getAsInt()); // 0
//        System.out.println(oi2.getAsInt()); // NoSuchElementException
        System.out.println(oi1.equals(oi2)); // false
        // int의 기본형 값은 0이기에 OptionalInt.of(0)과 OptionalInt.empty()에 모두 0이 저장되지만
        // isPresent가 둘을 다른 값으로 구별해준다.
        Optional<String> opt1 = Optional.ofNullable(null);
        Optional<String> opt2 = Optional.empty();
        System.out.println(opt1.equals(opt2));
        // Optional 객체는 null을 저장한 것과 empty를 동일하게 취급한다.
        Optional<String> opt3 = Optional.ofNullable("아야어여오요우유");
        System.out.println(optStrToInt(opt3, 10)); //10
    }
    static int optStrToInt(Optional<String> opt, int defaultValue) {
        try {
            return opt.map(Integer::parseInt).get();
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
