package java8.optional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/*
*
* Optional 이전?
* null 체크를 깜빡하면 에러 발생
* 매번 널 체크에 리소스 사용
*
* .of() -> 무조건 널이 아니다
* .ofNullable() -> 널일 수도 있다.
* 리턴값으로만 사용할 것을 권장한다.
*
* map에도 Optional을 쓰면 안된다.
* map의 파라미터는 비어있지 않은 것이 원치이다.
*
* primitive type은 OptionalInt같은 것을 사용하자(언박싱, 박싱 리소스 절약)
*
* Optional 반환값을 가진 메서드에서 절대 Null을 반환하지 말 것.
*
* Collection, Map, Stream, Optional 등 내부가 비어있는 것을
*
* */

public class OptionalStudy {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(1, "spring jyp", true));
        springClasses.add(new OnlineClass(1, "spring sm", true));
        springClasses.add(new OnlineClass(1, "spring core", true));
        springClasses.add(new OnlineClass(1, "spring starter", false));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
//        Duration studyDuration = spring_boot.getProgres().getStudyDuration(); 널포인트 예외 ㅏ발생

        if (spring_boot.getProgres() != null) {
            System.out.println(spring_boot.getProgres().getStudyDuration());
        } // 이전

        Optional.ofNullable(spring_boot.getProgres()).ifPresent(
                e -> System.out.println(e.getStudyDuration())
        );

        OptionalInt.of(10);

        OnlineClass onlineClass = new OnlineClass(1, "as", true);
//        onlineClass.getOptionalString(); 널
    }
}
