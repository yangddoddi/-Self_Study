package java8.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
*
* Stream에서 반환값을 확신할 수 없는 경우 Optional로 반환해줌
* .isPresent() Null여부를 Boolean으로 반환(널이면 false)
* .get() null일 경우 RuntimeException 발생
* .ifPresent() null이 아닐 경우 ~ 하라
* T.orElse(T other) null일 경우 ~ 하라 -> 반환 값을 그대로 받으며, 무조건 인스턴스화됨
* orElseGet(Supplier<? extents T> other) -> lazy로딩으로 필요할 때 값을 가져온다 null일 경우에만 함수가 실행된다.
* .isEmpty() 널 여부 반환(null이면 true)
*
* Optional로 반환 받은 값이 Optional이라면 ? flatMap()으로 한 번에 꺼낼 수 있다
*
*
* */

public class OptionalApis {
    public static void main(String[] args) {
        List<OnlineClass> spirngClasses = new ArrayList<>();
        spirngClasses.add(new OnlineClass(1, "spring boot", true));
        spirngClasses.add(new OnlineClass(5, "rest spring mvp", false));

        Optional<OnlineClass> spring = spirngClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
        // 자동으로 옵셔널로 반환해줌

        boolean present = spring.isPresent();
        spring.ifPresent(
                o -> System.out.println("히히 신나")
        );

        OnlineClass newClass = spring.orElse(new OnlineClass(1, "hehe", true));
        // 없으면 새로운 클래스 반환
        OnlineClass hehe = spring.orElseGet(() -> new OnlineClass(1, "hehe", true));
        System.out.println("orElse = " + newClass + ", orElseGet = " + hehe);
        OnlineClass onlineClass = spring.orElseThrow(() -> new IllegalArgumentException());
    }
}
